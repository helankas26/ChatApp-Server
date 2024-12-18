/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.service;

import com.chatapp.pojos.Chat;
import com.chatapp.pojos.User;
import com.chatapp.rmi.ChatRemote;
import com.chatapp.util.Connection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Helanka
 */
public class ChatService extends UnicastRemoteObject implements ChatRemote {

    public ChatService() throws RemoteException{
        super();
    }
    
    @Override
    public ArrayList<Chat> getAllChat() {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        ArrayList<Chat> chats = (ArrayList<Chat>) s.createQuery("from Chat").list();
        
//        t.commit();
        s.close();
        
        return chats;
    }
    
    @Override
    public boolean createChat(Chat chat) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.save(chat);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public Chat getChat(Chat chat) {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        Chat c = (Chat) s.get(Chat.class, chat.getChatId());
        
//        t.commit();
        s.close();
        
        return c;
    }
    
    @Override
    public boolean updateChat(Chat chat) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.update(chat);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public boolean deleteChat(Chat chat) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        Chat c = (Chat) s.get(Chat.class, chat.getChatId());
        s.delete(c);
        
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public boolean putOnline(Chat chat) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        Chat c = (Chat) s.get(Chat.class, chat.getChatId());
        c.setStatus(1);
        
        s.update(c);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public boolean putOffline(Chat chat) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        Chat c = (Chat) s.get(Chat.class, chat.getChatId());
        c.setStatus(0);
        
        s.update(c);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public boolean putAllOffline() throws RemoteException {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        Query query = s.createQuery("update Chat set status = :status");
        query.setParameter("status", 0);
        query.executeUpdate();
                
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public boolean isChatOnline() {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        Query query = s.createQuery("from Chat where status = :status");
        query.setParameter("status", 1);
        Chat chat = (Chat) query.uniqueResult();
        
//        t.commit();
        s.close();
        
        return chat != null;
    }

    @Override
    public ArrayList<Chat> getSubscribedChats(User user) throws RemoteException {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        Query query = s.createQuery("from Chat c where chatId in ("
                + "select c.chatId "
                + "from Chat c "
                + "left join c.subscriptions s "
                + "where s.id.userId = :userId) order by c.status desc"
        );
        query.setParameter("userId", user.getUserId());
        ArrayList<Chat> users = (ArrayList<Chat>) query.list();
    
//        t.commit();
        s.close();
        
        return users;
    }

    @Override
    public ArrayList<Chat> getToSubscribeChats(User user) throws RemoteException {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        Query query = s.createQuery("from Chat c where chatId not in ("
                + "select c.chatId "
                + "from Chat c "
                + "left join c.subscriptions s "
                + "where s.id.userId = :userId) order by c.status desc"
        );
        query.setParameter("userId", user.getUserId());
        ArrayList<Chat> users = (ArrayList<Chat>) query.list();        
    
//        t.commit();
        s.close();
        
        return users;
    }
}
