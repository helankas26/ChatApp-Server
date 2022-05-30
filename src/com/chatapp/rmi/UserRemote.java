/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.rmi;

import com.chatapp.pojos.User;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Helanka
 */
public interface UserRemote {
    public List<User> getAllUser() throws RemoteException;
    public boolean registerUser(User user)throws RemoteException; 
    public User getUser(User user)throws RemoteException;
    public boolean updateUser(User user)throws RemoteException; 
    public boolean deleteUser(User user)throws RemoteException;
    public List<User> login(String username, String password) throws RemoteException;
}
