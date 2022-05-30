/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.rmi;

import com.chatapp.pojos.Chatsession;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Helanka
 */
public interface ChatsessionRemote {
    
    public List<Chatsession> getAllChatsession() throws RemoteException;
    public boolean createChatsession(Chatsession chatsession) throws RemoteException; 
    public Chatsession getChatsession(Chatsession chatsession) throws RemoteException;
    public boolean updateChatsession(Chatsession chatsession) throws RemoteException; 
    public boolean deleteChatsession(Chatsession chatsession) throws RemoteException;
}
