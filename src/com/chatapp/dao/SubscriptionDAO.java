/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.dao;

import com.chatapp.pojos.Subscription;
import com.chatapp.util.Connection;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Helanka
 */
public class SubscriptionDAO {
    
    public List<Subscription> getAllSubscribers() {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        List<Subscription> subscriptions = s.createQuery("from Subscription").list();
        
        t.commit();
        s.close();
        
        return subscriptions;
    }
    
    public boolean subscribe(Subscription subscription) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.save(subscription);
        t.commit();
        s.close();
        
        return true;
    }
    
    public Subscription getSubscriber(Subscription subscription) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        Subscription sb = (Subscription) s.get(Subscription.class, subscription.getId().getUserId());
        
        t.commit();
        s.close();
        
        return sb;
    }
    
    public boolean updateSubscriber(Subscription subscription) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.update(subscription);
        t.commit();
        s.close();
        
        return true;
    }
    
    public boolean unsubscribe(Subscription subscription) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        Subscription sb = (Subscription) s.get(Subscription.class, subscription.getId());
        s.delete(sb);
        
        t.commit();
        s.close();
        
        return true;
    }
}
