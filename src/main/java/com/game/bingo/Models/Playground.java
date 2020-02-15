package com.game.bingo.Models;

import java.util.HashSet;
import java.util.Set;

public class Playground {
    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    Set<Room> rooms;
    public Playground(){
        this.rooms = new HashSet<>();
    }
}
