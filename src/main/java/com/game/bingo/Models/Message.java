package com.game.bingo.Models;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_message;

    private String content;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;

    public long getId_message() {
        return id_message;
    }

    public void setId_message(long id_message) {
        this.id_message = id_message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;

}
