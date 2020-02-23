package com.game.bingo.Controller;

import com.game.bingo.Models.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/room/{id}/chat/sendMessage")
    @SendTo("/room/{id}/subscribers")
    public Message sendMessage(@DestinationVariable int id, Message message){
        return message;
    }


}
