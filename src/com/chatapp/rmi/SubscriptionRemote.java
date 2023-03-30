/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.rmi;

import com.chatapp.pojos.Subscription;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Helanka
 */
public interface SubscriptionRemote extends Remote {
    
    public List<Subscription> getAllSubscribers() throws RemoteException;
    public boolean subscribe(Subscription subscription) throws RemoteException; 
    public Subscription getSubscriber(Subscription subscription) throws RemoteException;
    public boolean updateSubscriber(Subscription subscription) throws RemoteException; 
    public boolean unsubscribe(Subscription subscription) throws RemoteException;
}
