/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatapp.pojos;

import java.util.Date;

/**
 *
 * @author Helanka
 */
public class Message {
    
    private User user;
    private Chatsession chatsession;
    private String msgBody;
    private Date sentAt;

    public Message() {
    }

    public Message(User user, Chatsession chatsession, String msgBody) {
        this.user = user;
        this.chatsession = chatsession;
        this.msgBody = msgBody;
    }

    public Message(User user, Chatsession chatsession, String msgBody, Date sentAt) {
        this.user = user;
        this.chatsession = chatsession;
        this.msgBody = msgBody;
        this.sentAt = sentAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chatsession getChatsession() {
        return chatsession;
    }

    public void setChatsession(Chatsession chatsession) {
        this.chatsession = chatsession;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }
    
    
}
