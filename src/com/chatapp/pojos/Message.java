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
    private ChatSession chatSession;
    private String msgBody;
    private Date sentAt;

    public Message() {
    }

    public Message(User user, ChatSession chatSession, String msgBody) {
        this.user = user;
        this.chatSession = chatSession;
        this.msgBody = msgBody;
    }

    public Message(User user, ChatSession chatSession, String msgBody, Date sentAt) {
        this.user = user;
        this.chatSession = chatSession;
        this.msgBody = msgBody;
        this.sentAt = sentAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChatSession getChatsession() {
        return chatSession;
    }

    public void setChatsession(ChatSession chatSession) {
        this.chatSession = chatSession;
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
