package com.game.bingo.Models;

import java.util.HashSet;
import java.util.Set;

public class Room {
    private static int current_id = 0;

    private int lastDraw;

    public long getId() {
        return id;
    }

    private long id;

    public Player getOwner() {
        return owner;
    }

    public int getLastDraw() {
        return lastDraw;
    }

    public void setLastDraw(int lastDraw) {
        this.lastDraw = lastDraw;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    private Set<Player> players = new HashSet<>();
    private Player owner;
    public Room(Player owner){
        this.owner = owner;
        this.id = current_id;
        current_id++;
    }
}
