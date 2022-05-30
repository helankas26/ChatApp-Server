package com.chatapp;

import com.chatapp.dao.ChatDAO;
import com.chatapp.dao.ChatsessionDAO;
import com.chatapp.dao.MessageDAO;
import com.chatapp.dao.SubscriptionDAO;
import com.chatapp.dao.UserDAO;
import com.chatapp.pojos.Chatsession;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Helanka
 */
public class Server {
    public static void main(String[] args) throws RemoteException {
        try {
               //Create remote object
               ChatDAO chatStub = new ChatDAO();
               ChatsessionDAO chatsessionStub = new ChatsessionDAO();
               MessageDAO messagechatsessionStub = new MessageDAO();
               SubscriptionDAO subscriptionStub = new SubscriptionDAO();
               UserDAO userStub = new UserDAO();


               //Create a remote registry
               Registry reg = LocateRegistry.createRegistry(4000);

               //Register the remote objects to the registry and advertise
               reg.rebind("ChatService", (Remote) chatStub);
               reg.rebind("ChatsessionService", (Remote) chatsessionStub);
               reg.rebind("MessageService", (Remote) messagechatsessionStub);
               reg.rebind("SubscriptionService", (Remote) subscriptionStub);
               reg.rebind("UserService", (Remote) userStub);

               System.out.println("Server is connected and running.....");
           } catch (RemoteException ex) {
               System.out.println("Server is not connected....." + ex.getMessage());
        }
    }
    
    
}
