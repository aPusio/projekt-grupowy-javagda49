package com.sda.games.r_p_s.game;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor

public enum Rps {

    ROCK(1),
    PAPER(2),
    SCISSORS(3);


    private int wartosc;

    public int getWartosc() {
        return wartosc;
    }

    public static Optional<Rps> getById(int value){
        return Arrays.stream(Rps.values())
                .filter(a -> a.wartosc == value)
                .findFirst();
    }

    public static Optional<Rps> getById2(int value){
        return Arrays.stream(Rps.values())
                .filter(a -> a.wartosc == value)
                .findFirst();
    }

}
