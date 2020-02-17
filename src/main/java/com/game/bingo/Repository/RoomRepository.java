package com.game.bingo.Repository;

import com.game.bingo.Models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
    List<Room> findFirstByCode(String code);
    List<Room> findByCode(String code);
}
