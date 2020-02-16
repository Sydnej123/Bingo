package com.game.bingo.Models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_room;

    @NotNull
    @Column(length = 5)
    private String code;

    @OneToMany(mappedBy = "room")
    private Set<Player> players;
}
