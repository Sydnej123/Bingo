package com.game.bingo.Models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_number;

    private int number;

    @ManyToOne
    @JoinColumn(name = "id_board")
    private Board board;
}
