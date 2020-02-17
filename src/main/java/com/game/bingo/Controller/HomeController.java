package com.game.bingo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(HttpSession session, Model model){
        return "home";
    }

    @GetMapping("/room/{id}")
    public String roomPage(HttpSession session, Model model, @PathVariable int id){
        return "room";
    }
}
