package com.game.bingo.Repository;

import com.game.bingo.Models.Message;
import com.game.bingo.Models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByRoom(Room room);
}
