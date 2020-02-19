package com.game.bingo.Repository;

import com.game.bingo.Models.Player;
import com.game.bingo.Models.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findByRoom(Room room);
}
