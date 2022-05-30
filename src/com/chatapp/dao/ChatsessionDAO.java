/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.dao;

import com.chatapp.pojos.Chatsession;
import com.chatapp.util.Connection;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Helanka
 */
public class ChatsessionDAO {
    
    public List<Chatsession> getAllChatsession() {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        List<Chatsession> chatsessions = s.createQuery("from Chatsession").list();
        
        t.commit();
        s.close();
        
        return chatsessions;
    }
    
    public boolean createUser(Chatsession chatsession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.save(chatsession);
        t.commit();
        s.close();
        
        return true;
    }
    
    public Chatsession getUser(Chatsession chatsession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        Chatsession cs = (Chatsession) s.get(Chatsession.class, chatsession.getSessionId());
        
        t.commit();
        s.close();
        
        return cs;
    }
    
    public boolean updateUser(Chatsession chatsession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.update(chatsession);
        t.commit();
        s.close();
        
        return true;
    }
    public boolean deleteUser(Chatsession chatsession) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        Chatsession cs = (Chatsession) s.get(Chatsession.class, chatsession.getSessionId());
        s.delete(cs);
        
        t.commit();
        s.close();
        
        return true;
    }
}