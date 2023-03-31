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
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.chatapp.rmi.ChatSessionRemote;
import java.util.ArrayList;

/**
 *
 * @author Helanka
 */
public class ChatSessionService extends UnicastRemoteObject implements ChatSessionRemote{
    
    public ChatSessionService() throws RemoteException{
        super();
    }
    
    @Override
    public ArrayList<ChatSession> getAllChatsession() {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        ArrayList<ChatSession> chatSessions = (ArrayList<ChatSession>) s.createQuery("from ChatSession").list();
        
//        t.commit();
        s.close();
        
        return chatSessions;
    }
    
    @Override
    public boolean startChatsession(ChatSession chatSession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.save(chatSession);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public ChatSession getChatsession(ChatSession chatSession) {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        ChatSession cs = (ChatSession) s.get(ChatSession.class, chatSession.getSessionId());
        
//        t.commit();
        s.close();
        
        return cs;
    }
    
    @Override
    public boolean endChatsession(ChatSession chatSession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.update(chatSession);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public boolean deleteChatsession(ChatSession chatSession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        ChatSession cs = (ChatSession) s.get(ChatSession.class, chatSession.getSessionId());
        s.delete(cs);
        
        t.commit();
        s.close();
        
        return true;
    }
}
