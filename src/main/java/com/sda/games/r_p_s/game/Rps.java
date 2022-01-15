package com.sda.games.r_p_s.game;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public enum Rps {

    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private int wartosc;

    public int getWartosc() {
        return wartosc;
    }

}
