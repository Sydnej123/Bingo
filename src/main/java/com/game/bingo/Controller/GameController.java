package com.game.bingo.Controller;

import com.game.bingo.Models.Player;
import com.game.bingo.Models.Room;
import com.game.bingo.Repository.PlayerRepository;
import com.game.bingo.Repository.RoomRepository;
import com.game.bingo.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

// getallplayers
// remove player
//             <div class="player">#1 Gracz<img th:src="@{/img/crown.png}" width="18" height="18"><div class="kickUser">x</div> </div>
@RestController
public class GameController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    RoomRepository roomRepository;

    @GetMapping(path = "/room/{id}/players")
    public List<Player> getListOfPlayersByRoomId(@PathVariable int id){
        return playerRepository.findByRoom(roomRepository.findById((long) id).get());
    }

    @PostMapping("/room/{id}/remove")
    public void removePlayerFromRoom(@RequestParam Map<String, String> params){
        playerRepository.deleteById((long) Integer.parseInt(params.get("id_player").toString()));
    }

    @PostMapping("/room/{id}/message/send")
    public void sendMessage(@RequestParam Map<String, String> params){

    }

    @GetMapping("/room/{id}/message")
    public String getMessages(@PathVariable long id){
        return "";
    }


}
