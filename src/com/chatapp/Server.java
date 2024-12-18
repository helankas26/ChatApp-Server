package com.chatapp;

import com.chatapp.rmi.ChatRemote;
import com.chatapp.rmi.ChatSessionRemote;
import com.chatapp.rmi.MessageRemote;
import com.chatapp.rmi.SubscriptionRemote;
import com.chatapp.rmi.UserRemote;
import com.chatapp.service.ChatService;
import com.chatapp.service.ChatSessionService;
import com.chatapp.service.MessageService;
import com.chatapp.service.SubscriptionService;
import com.chatapp.service.UserService;
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
    public static void main(String[] args) {
        try {
               //Create remote object
               ChatRemote chatStub = new ChatService();
               ChatSessionRemote chatSessionStub = new ChatSessionService();
               //MessageRemote messageStub = new MessageService();
               SubscriptionRemote subscriptionStub = new SubscriptionService();
               UserRemote userStub = new UserService();


               //Create a remote registry
               Registry reg = LocateRegistry.createRegistry(4000);

               //Register the remote objects to the registry and advertise
               reg.rebind("ChatService", chatStub);
               reg.rebind("ChatSessionService", chatSessionStub);
               //reg.rebind("MessageService", messageStub);
               reg.rebind("SubscriptionService", subscriptionStub);
               reg.rebind("UserService", userStub);

               System.out.println("Server is connected and running.....");
           } catch (RemoteException ex) {
               System.out.println("Server is not connected....." + ex.getMessage());
        }
    }
    
    
}
