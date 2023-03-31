/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.rmi;

import com.chatapp.pojos.ChatSession;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Helanka
 */
public interface ChatSessionRemote extends Remote {
    
    public ArrayList<ChatSession> getAllChatsession() throws RemoteException;
    public boolean startChatsession(ChatSession chatsession) throws RemoteException; 
    public ChatSession getChatsession(ChatSession chatsession) throws RemoteException;
    public boolean endChatsession(ChatSession chatsession) throws RemoteException; 
    public boolean deleteChatsession(ChatSession chatsession) throws RemoteException;
    
}
