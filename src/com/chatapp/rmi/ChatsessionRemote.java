/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.rmi;

import com.chatapp.pojos.ChatSession;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Helanka
 */
public interface ChatSessionRemote {
    
    public List<ChatSession> getAllChatsession() throws RemoteException;
    public boolean createChatsession(ChatSession chatsession) throws RemoteException; 
    public ChatSession getChatsession(ChatSession chatsession) throws RemoteException;
    public boolean updateChatsession(ChatSession chatsession) throws RemoteException; 
    public boolean deleteChatsession(ChatSession chatsession) throws RemoteException;
}
