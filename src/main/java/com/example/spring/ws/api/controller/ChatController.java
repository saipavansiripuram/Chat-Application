package com.example.spring.ws.api.controller;

import com.example.spring.ws.api.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.register") //Map the same url client to server
    @SendTo("/topic/public") //helps in specify the queue request channel and response channel based on url
    public ChatMessage register(@Payload ChatMessage chatMessage,SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
        return chatMessage;
    }
    @MessageMapping("/chat.send") //Map the same url client to server
    @SendTo("/topic/public") //helps in specify the queue request channel and response channel based on url
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        return chatMessage;
    }
}
