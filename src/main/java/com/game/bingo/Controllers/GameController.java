package com.game.bingo.Controllers;

import com.game.bingo.Models.Board;
import com.game.bingo.Models.Player;
import com.game.bingo.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/boards")
    public Set<Board> getBoardsByUserId(@RequestParam(name = "id", defaultValue = "0") int id){
        return gameService.getAllBoardByUserId(id);
    }

    @GetMapping("/room")
    public Set<Player> getPlayersInRoom(@RequestParam(name = "id", defaultValue = "0") int id){
        return gameService.getPlayersInRoom(id);
    }

    @GetMapping("/room/owner")
    public Player getRoomOwner(@RequestParam(name = "id", defaultValue = "0") int id){
        return gameService.getRoomOwnerById(id);
    }

    @GetMapping("/boards/create")
    public Board createNewBoard(@RequestParam(name = "id", defaultValue = "0") int id){
        return gameService.createNewBoard(id);
    }

    @GetMapping("/boards/owner")
    public Set<Integer> getOwnerNumbers(@RequestParam(name = "id", defaultValue = "0") int id){
        return gameService.getOwnerNumbers(id);
    }
    @GetMapping("/room/kick")
    public void kickUserFromRoom(@RequestParam(name = "id", defaultValue = "0")int id){
        gameService.kickUser(id);
    }
    
}
