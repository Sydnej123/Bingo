package com.game.bingo.Services;

import com.game.bingo.Models.Room;
import com.game.bingo.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    RoomRepository roomRepository;
    public int createNewRoom(){
        Room room = new Room();
        roomRepository.save(room);

    }


}
