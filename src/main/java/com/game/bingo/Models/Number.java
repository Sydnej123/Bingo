package com.game.bingo.Models;

import lombok.Data;
import javax.persistence.*;

@Entity
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_number;

    public long getId_number() {
        return id_number;
    }

    public void setId_number(long id_number) {
        this.id_number = id_number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private int number;

    @ManyToOne
    @JoinColumn(name = "id_board")
    private Board board;
}
