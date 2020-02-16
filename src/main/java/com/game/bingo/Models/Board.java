package com.game.bingo.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_board;

    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;

    @OneToMany(mappedBy = "board")
    private Set<Number> numbers;
}
