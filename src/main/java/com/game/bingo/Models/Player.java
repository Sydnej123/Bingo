package com.game.bingo.Models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_player;
    @NotNull
    @Column(length = 20)
    private long name;
    private boolean is_owner;

    @ManyToOne
    @JoinColumn(name="id_room", nullable = false)
    private Room room;
}


