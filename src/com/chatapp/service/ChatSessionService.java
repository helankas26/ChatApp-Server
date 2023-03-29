/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.service;

import com.chatapp.pojos.ChatSession;
import com.chatapp.util.Connection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.chatapp.rmi.ChatSessionRemote;

/**
 *
 * @author Helanka
 */
public class ChatSessionService extends UnicastRemoteObject implements ChatSessionRemote{
    
    public ChatSessionService() throws RemoteException{
        super();
    }
    
    @Override
    public List<ChatSession> getAllChatsession() {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        List<ChatSession> chatsessions = s.createQuery("from Chatsession").list();
        
        t.commit();
        s.close();
        
        return chatsessions;
    }
    
    @Override
    public boolean createChatsession(ChatSession chatsession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.save(chatsession);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public ChatSession getChatsession(ChatSession chatsession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        ChatSession cs = (ChatSession) s.get(ChatSession.class, chatsession.getSessionId());
        
        t.commit();
        s.close();
        
        return cs;
    }
    
    @Override
    public boolean updateChatsession(ChatSession chatsession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.update(chatsession);
        t.commit();
        s.close();
        
        return true;
    }
    @Override
    public boolean deleteChatsession(ChatSession chatsession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        ChatSession cs = (ChatSession) s.get(ChatSession.class, chatsession.getSessionId());
        s.delete(cs);
        
        t.commit();
        s.close();
        
        return true;
    }
}
