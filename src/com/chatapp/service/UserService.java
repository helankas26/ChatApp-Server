/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.service;

import com.chatapp.pojos.Chat;
import com.chatapp.pojos.User;
import com.chatapp.rmi.UserRemote;
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
public class UserService extends UnicastRemoteObject implements UserRemote {
    
    public UserService() throws RemoteException{
        super();
    }
    
    @Override
    public ArrayList<User> getAllUser() {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        ArrayList<User> users = (ArrayList<User>) s.createQuery("from User").list();
        
//        t.commit();
        s.close();
        
        return users;
    }
    
    @Override
    public boolean registerUser(User user) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.save(user);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public User getUser(User user) {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        User u = (User) s.get(User.class, user.getUserId());
        
//        t.commit();
        s.close();
        
        return u;
    }
    
    @Override
    public boolean updateUser(User user) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        s.update(user);
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public boolean deleteUser(User user) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        User u = (User) s.get(User.class, user.getUserId());
        s.delete(u);
        
        t.commit();
        s.close();
        
        return true;
    }
    
    @Override
    public User login(User user) {
        Session s = Connection.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
        
        final String password = user.getPassword();
        
        Query query = s.createQuery("from User where username = :username");
        query.setParameter("username", user.getUsername());
        user = (User) query.uniqueResult();
        
        if (!user.getPassword().equals(password)) {
            user.setPassword(null);
        }
        
//        t.commit();
        s.close();
        
        return user;
    }

    @Override
    public ArrayList<User> getSubscribedUsers(Chat chat) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<User> getToSubscribeUsers(Chat chat) throws RemoteException {
        return null;
    }

    
}
