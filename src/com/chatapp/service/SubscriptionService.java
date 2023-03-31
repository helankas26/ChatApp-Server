/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.service;

import com.chatapp.pojos.Subscription;
import com.chatapp.rmi.SubscriptionRemote;
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
public class SubscriptionService extends UnicastRemoteObject implements SubscriptionRemote{
    
    public SubscriptionService() throws RemoteException{
        super();
    }
    
    @Override
    public ArrayList<Subscription> getAllSubscribers() {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        ArrayList<Subscription> subscriptions = (ArrayList<Subscription>) s.createQuery("from Subscription").list();
        
//        t.commit();
        s.close();
        
        return subscriptions;
    }
    
    @Override
    public boolean subscribe(Subscription subscription) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.save(subscription);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public Subscription getSubscriber(Subscription subscription) {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        Subscription sb = (Subscription) s.get(Subscription.class, subscription.getId().getUserId());
        
//        t.commit();
        s.close();
        
        return sb;
    }
    
    @Override
    public boolean updateSubscriber(Subscription subscription) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.update(subscription);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
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
