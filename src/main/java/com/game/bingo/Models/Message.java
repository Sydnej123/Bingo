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

    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;

}
