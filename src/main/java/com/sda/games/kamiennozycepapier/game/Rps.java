package com.sda.games.kamiennozycepapier.game;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public enum Rps {

    KAMIEN(1),
    PAPIER(2),
    NOZYCE(3);

    private int wartosc;

    public int getWartosc() {
        return wartosc;
    }

}
