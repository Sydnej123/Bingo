package com.game.bingo.Controllers;

import com.game.bingo.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomePageController {
    
    @Autowired
    GameService gameService;
    
    @GetMapping("/")
    public String renderHomePage(Model model){
        return "home";
    }

    @PostMapping("/createroom")
    public String createGame(@RequestParam String name, Model model){
        long roomId =  gameService.createRoom(name);
        model.addAttribute("ownerName", name);
        model.addAttribute("roomId", roomId);

        return "redirect:/room/"+roomId;
    }

    @PostMapping("/joinroom")
    public String joinRoom(@RequestParam String name, @RequestParam String roomId, Model model){
        gameService.joinRoom(name, roomId);
        return "redirect:/room/" + roomId;

    }

    @GetMapping("/room/{id}")
    public String getRoom(@PathVariable int id, Model model){
        model.addAttribute("ownerName", gameService.getOwnerName(id));
        model.addAttribute("roomId", id);
        return "room";
    }

}
