package com.game.bingo.Models;

import java.util.Set;

public class Board {
    private static int current_id = 0;
    private long id;
    private Set<Integer> numbers;

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", numbers=" + numbers +
                '}';
    }

    public Board(Set<Integer> numbers){
        this.numbers = numbers;
        this.id = current_id;
        current_id++;
    }
}
