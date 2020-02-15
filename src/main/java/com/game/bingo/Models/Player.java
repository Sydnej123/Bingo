package com.game.bingo.Models;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private static int current_id = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name) {
        this.id = current_id;
        this.name = name;
        boards = new HashSet<>();
        current_id++;
    }

    private Set<Board> boards;

    public Set<Board> getBoards() {
        return boards;
    }

    public void setBoards(Set<Board> boards) {
        this.boards = boards;
    }
}
