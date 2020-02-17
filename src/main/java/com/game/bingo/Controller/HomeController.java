package com.game.bingo.Controller;

import com.game.bingo.Models.JoinForm;
import com.game.bingo.Models.Room;
import com.game.bingo.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Map;

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

    @Autowired
    GameService gameService;

    @PostMapping("/create")
    public RedirectView create(@RequestBody String ownerName, HttpSession session){
        Room room = gameService.createNewRoom();
        long ownerId = gameService.createOwner(room, ownerName);
        session.setAttribute("ownerId", ownerId);
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/room/"+room.getId_room());
        return rv;
    }

    @PostMapping("/join")
    public RedirectView join(@RequestParam Map<String, String> body, HttpSession session){
        System.out.println("Imie z body: " +body.get("name") + " Kod " + body.get("code"));
        int playerId = gameService.join(body.get("name"), body.get("code"));
        session.setAttribute("playerId", playerId);
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/room/"+gameService.getRoomByCode(body.get("code")).getId_room());
        return rv;
    }


}


