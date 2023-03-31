/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.service;

import com.chatapp.pojos.Chat;
import com.chatapp.rmi.ChatRemote;
import com.chatapp.util.Connection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
     public boolean isChatOnline() {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        Chat chat = (Chat) s.createQuery("from Chat where status = 1");
        
//        t.commit();
        s.close();
        
        return chat != null;
        
    }
    
}
