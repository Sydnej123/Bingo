package com.game.bingo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_player;

    @NotNull
    @Column(length = 20)
    private String name;
    private boolean is_owner;

    public long getId_player() {
        return id_player;
    }

    public void setId_player(long id_player) {
        this.id_player = id_player;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_owner() {
        return is_owner;
    }

    public void setIs_owner(boolean is_owner) {
        this.is_owner = is_owner;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="room_id", nullable = false)
    private Room room;
}


