package com.game.bingo.Services;

import com.game.bingo.Models.Player;
import com.game.bingo.Models.Room;
import com.game.bingo.Repository.PlayerRepository;
import com.game.bingo.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    PlayerRepository playerRepository;

    public Room createNewRoom(){
        Room room = new Room();
        room.setCode(generateJoinCode());
        roomRepository.save(room);
        return room;
    }

    private String generateJoinCode() {
        Random r = new Random();
        String code = null;
        boolean isUnique = false;
        while(!isUnique){
            code = "";
            for(int i = 0; i < 5; i++){
                if(r.nextBoolean()){
                    code += Character.toString((char) r.nextInt(9) + 48);
                }else{
                    code += Character.toString((char) r.nextInt(25) + 65);
                }

            }
            isUnique =  checkIfCodeIsUnique(code);
        }
        return code;
    }


    private boolean checkIfCodeIsUnique(String code) {
        return roomRepository.findByCode(code).size() > 0 ? false : true;
    }

    public long createOwner(Room room, String name){
        Player owner = new Player();
        owner.setName(name);
        owner.setIs_owner(true);
        owner.setRoom(room);
        playerRepository.save(owner);
        room.getPlayers().add(owner);
        return owner.getId_player();
    }

    public Room getRoomByCode(String code){
        List<Room> room = roomRepository.findFirstByCode(code);
            return room.isEmpty() ? null : room.get(0);
    }


    public int join(String name, String code) {
        Player player = new Player();
        player.setName(name);
        Room room = getRoomByCode(code);
        player.setRoom(room);
        playerRepository.save(player);

        room.getPlayers().add(player);
        return (int) room.getId_room();
    }


}
