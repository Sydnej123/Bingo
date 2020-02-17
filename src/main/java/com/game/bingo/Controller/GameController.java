package com.game.bingo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class GameController {

    @PostMapping("/create")
    public String create(HttpSession session){

        return "redirect: /room/" + session.getAttribute("roomId");
    }

}
