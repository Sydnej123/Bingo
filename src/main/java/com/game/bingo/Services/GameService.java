package com.game.bingo.Services;

import com.game.bingo.Models.Board;
import com.game.bingo.Models.Player;
import com.game.bingo.Models.Playground;
import com.game.bingo.Models.Room;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@Configuration
public class GameService {

    private Playground playground;

    @Bean
    CommandLineRunner init(){
        return args -> {
            playground = new Playground();
        };

    }

    public long createRoom(String playerName){
        Player player = new Player(playerName);
        Room room = new Room(player);
        room.setOwner(player);
        playground.getRooms().add(room);
        addPlayerToRoom(player, (int) room.getId());
        return  room.getId();
    }

    public void joinRoom(String playerName, String roomId){
        Player player = new Player(playerName);
        addPlayerToRoom(player, Integer.parseInt(roomId));
    }

    public Set<Board> getAllBoardByUserId(int id){
        return playground.getRooms()
                .stream()
                .filter(room -> room.getPlayers().stream().filter(player -> player.getId() == id).count() > 0 )
                .findFirst()
                .get()
                .getPlayers()
                .stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .get()
                .getBoards();

    }

    private void addPlayerToRoom(Player player, int roomId){
        playground.getRooms()
                .stream()
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .get()
                .getPlayers()
                .add(player);
    }


    public Set<Player> getPlayersInRoom(int id) {
        return playground.getRooms().stream()
                    .filter(room -> room.getId() == id)
                    .findFirst()
                    .get()
                    .getPlayers();
    }

    public Board createNewBoard(int id){
        Board board = randomBoard();
        System.out.println(board);
         playground.getRooms().stream()
                .filter(room -> room.getPlayers().stream().filter(player -> player.getId() == id).count() > 0 )
                .findFirst()
                .get()
                .getPlayers()
                .stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .get()
                .getBoards()
                 .add(board);
         return board;
    }

    private Board randomBoard() {
        Set<Integer> randomSet = new HashSet<>();
        Random r = new Random();
        // At least one number in each ten
        for(int i = 0; i < 10; i++){
            randomSet.add(r.nextInt(1 + i * 10));
        }
        // Other numbers. Cannot be more than 3 in each row
        while(randomSet.size() < 15){
            int random = r.nextInt(90);
            int randomTens = random/10;
            if(randomSet.stream()
                    .filter(number -> number.doubleValue() >= 0 + randomTens * 10 && number < 10 + randomTens * 10)
                    .count() < 3){
                randomSet.add(random);
                }

        }
        return new Board(randomSet);
    }

    public Player getRoomOwnerById(int id) {
        return playground.getRooms().stream()
                .filter(room -> room.getId() == id)
                .findFirst()
                .get()
                .getOwner();
    }

    public String getOwnerName(int id) {
        return playground.getRooms()
                .stream()
                .filter(room -> room.getId() == id)
                .findFirst()
                .get()
                .getOwner()
                .getName();
    }

    public Set<Integer> getOwnerNumbers(int id) {
        return playground.getRooms()
                .stream()
                .filter(room -> room.getId() == id)
                .findFirst()
                .get()
                .getOwner()
                .getBoards()
                .stream()
                .findFirst()
                .get()
                .getNumbers();
    }

    public void drawRandomNumber(int id){
        int previousBoardSize = 0;
        int currentBoardSize = 0;
        int randomNumber = 0;
        Random r = new Random();
        while(previousBoardSize-currentBoardSize == 0){
            previousBoardSize = playground.getRooms()
                    .stream()
                    .filter(room -> room.getId() == id)
                    .findFirst()
                    .get()
                    .getOwner()
                    .getBoards()
                    .stream()
                    .findFirst()
                    .get()
                    .getNumbers()
                    .size();

            randomNumber = r.nextInt(90);

            playground.getRooms()
                    .stream()
                    .filter(room -> room.getId() == id)
                    .findFirst()
                    .get()
                    .getOwner()
                    .getBoards()
                    .stream()
                    .findFirst()
                    .get()
                    .getNumbers()
                    .add(randomNumber);

            currentBoardSize = playground.getRooms()
                    .stream()
                    .filter(room -> room.getId() == id)
                    .findFirst()
                    .get()
                    .getOwner()
                    .getBoards()
                    .stream()
                    .findFirst()
                    .get()
                    .getNumbers()
                    .size();
        }

        playground.getRooms()
                .stream()
                .filter(room -> room.getId() == id)
                .findFirst()
                .get()
                .setLastDraw(randomNumber);
    }

    public int getLastNumber(int id){
        return playground.getRooms()
                .stream()
                .filter(room -> room.getId() == id)
                .findFirst()
                .get()
                .getLastDraw();
    }
    

    public void kickUser(int id){
        playground.getRooms().stream()
                .filter(room -> room.getPlayers().stream().filter(player -> player.getId() == id).count() > 0 )
                .findFirst()
                .get()
                .getPlayers().remove(playground.getRooms().stream()
                .filter(room -> room.getPlayers().stream().filter(player -> player.getId() == id).count() > 0 )
                .findFirst()
                .get()
                .getPlayers()
                .stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .get());


    }


}
