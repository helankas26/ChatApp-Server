/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.service;

import com.chatapp.pojos.User;
import com.chatapp.rmi.UserRemote;
import com.chatapp.util.Connection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
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
    public List<User> getAllUser() {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        List<User> users = s.createQuery("from User").list();
        
        t.commit();
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
        Transaction t = s.beginTransaction();
        
        User u = (User) s.get(User.class, user.getUserId());
        
        t.commit();
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
    public List<User> login(String username, String password) {
        Session s = Connection.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        List<User> user = s.createQuery("from User where username = '" + username + "' AND password = '" + password + "'").list();
        
        t.commit();
        s.close();
        
        return user;
    }
}
