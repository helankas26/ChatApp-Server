package com.chatapp.pojos;
// Generated 30-May-2022 06:35:13 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Chat generated by hbm2java
 */
public class Chat  implements java.io.Serializable {


     private int chatId;
     private String name;
     private String description;
     private byte[] avatar;
     private int status;
     private Date createdAt;
     private Set subscriptions = new HashSet(0);
     private Set chatsessions = new HashSet(0);

    public Chat() {
    }

	
    public Chat(int chatId, String name, int status) {
        this.chatId = chatId;
        this.name = name;
        this.status = status;
    }
    public Chat(int chatId, String name, String description, byte[] avatar, int status, Date createdAt, Set subscriptions, Set chatsessions) {
       this.chatId = chatId;
       this.name = name;
       this.description = description;
       this.avatar = avatar;
       this.status = status;
       this.createdAt = createdAt;
       this.subscriptions = subscriptions;
       this.chatsessions = chatsessions;
    }
   
    public int getChatId() {
        return this.chatId;
    }
    
    public void setChatId(int chatId) {
        this.chatId = chatId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public byte[] getAvatar() {
        return this.avatar;
    }
    
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Set getSubscriptions() {
        return this.subscriptions;
    }
    
    public void setSubscriptions(Set subscriptions) {
        this.subscriptions = subscriptions;
    }
    public Set getChatsessions() {
        return this.chatsessions;
    }
    
    public void setChatsessions(Set chatsessions) {
        this.chatsessions = chatsessions;
    }




}


