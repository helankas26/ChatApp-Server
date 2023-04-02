/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.rmi;

import com.chatapp.pojos.Chat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Helanka
 */
public interface ChatRemote extends Remote {
    
    public ArrayList<Chat> getAllChat() throws RemoteException;
    public boolean createChat(Chat chat) throws RemoteException; 
    public Chat getChat(Chat chat) throws RemoteException;
    public boolean updateChat(Chat chat) throws RemoteException; 
    public boolean deleteChat(Chat chat) throws RemoteException; 
    public boolean putOnline(Chat chat) throws RemoteException; 
    public boolean putOffline(Chat chat) throws RemoteException;
    public boolean putAllOffline() throws RemoteException; 
    public boolean isChatOnline() throws RemoteException; 
}