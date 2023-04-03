/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.rmi;

import com.chatapp.pojos.Chat;
import com.chatapp.pojos.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Helanka
 */
public interface UserRemote extends Remote {
    public ArrayList<User> getAllUser() throws RemoteException;
    public boolean registerUser(User user) throws RemoteException; 
    public User getUser(User user) throws RemoteException;
    public boolean updateUser(User user) throws RemoteException; 
    public boolean deleteUser(User user) throws RemoteException;
    public boolean blockUser(User user) throws RemoteException;
    public boolean unblockUser(User user) throws RemoteException;
    public User login(User user) throws RemoteException;
    
    public ArrayList<User> getSubscribedUsers(Chat chat) throws RemoteException;
    public ArrayList<User> getToSubscribeUsers(Chat chat) throws RemoteException;
}
