package com.chatapp;

import com.chatapp.service.ChatService;
import com.chatapp.service.ChatSessionService;
import com.chatapp.service.SubscriptionService;
import com.chatapp.service.UserService;
import com.chatapp.pojos.Chat;
import com.chatapp.pojos.ChatSession;
import com.chatapp.pojos.Subscription;
import com.chatapp.pojos.SubscriptionId;
import com.chatapp.pojos.User;
import java.rmi.RemoteException;
import java.time.Instant;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Helanka
 */
public class ServerMain {
  //    public static void main(String[] args) throws RemoteException {
//        ///////////////////////// userr/////////////////
//        
////        User n = new User();
////        
////        n.setUsername("qqqq");
////        n.setPassword("12345678");
////        n.setRole("User");
////        n.setEmail("asbduat@djowh.com");
////        n.setNickname("helanka");
////        
////        UserDAO a = new UserDAO();
////        a.registerUser(n);
//        
//         ///////////////////////// Chat/////////////////
//
//        Chat c = new Chat();
//        
//        //c.setChatId(1);
//        c.setName("zzz");
//        c.setDescription("sds ds  zzdsds");
//        c.setStatus(0);
//        c.setCreatedAt(Date.from(Instant.now()));
//        
//        ChatDAO d = new ChatDAO();
//        d.createChat(c);
//      
//
//
//
//
///////////////////////////session////////////////////////////////
//
//        
////        Chat aa = new Chat();
////        aa.setChatId(2);
////        ChatDAO na = new ChatDAO();
////        aa = na.getChat(aa);
////        
////       
////        Chatsession ss = new Chatsession();
////       
////        
////        ss.setChat(aa);
////        ss.setLink("aaaaa.ser");
////        ss.setStartedAt(Date.from(Instant.now()));
////        
////        ChatsessionDAO l = new ChatsessionDAO();
////        l.createChatsession(ss);
//        
//        
/////////////////////////// subscribe////////////////////////////////
////
////        User q = new User();
////        q.setUserId(2);
////        
////        UserDAO q1 = new UserDAO();
////        q = q1.getUser(q);
////        
////        Chat w = new Chat();
////        w.setChatId(3);
////        
////        ChatDAO q2 = new ChatDAO();
////        w = q2.getChat(w);
////        
////       SubscriptionId v= new SubscriptionId();
////       v.setChatId(3);
////       v.setUserId(2);
////
////       Subscription qqqq = new Subscription();
////       qqqq.setId(v);
////       qqqq.setChat(w);
////       qqqq.setUser(q);
////       qqqq.setRegisteredAt(Date.from(Instant.now()));
////       
////        
////        SubscriptionDAO p = new SubscriptionDAO();
////        p.subscribe(qqqq);
////        
//
//      System.exit(0);
//        
//        
//    }
}
