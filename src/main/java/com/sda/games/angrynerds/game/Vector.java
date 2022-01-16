package com.sda.games.angrynerds.game;

import lombok.Getter;

@Getter
public class Vector {
    private final Integer x;
    private final Integer y;

    //TODO valitade
    public Vector(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Vector next() {
        int newX = this.x > 0 ? x - 1 : x;
        int newY = this.y - 1;
        return new Vector(newX, newY);
    }

    public Position apply(Position angryNerd) {
        return Position.of(angryNerd.getX() + x, angryNerd.getY() + y);
    }
}
