package com.game.bingo.Controller;

import com.game.bingo.Models.Room;
import com.game.bingo.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@RestController
public class GameController {

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

}
