package com.sda.games.checkers.model;

public class SpotFactory {
    public static Spot regularWhite(int x, int y) {
        return new Spot(x, y, new RegularPiece(true));
    }
    public static Spot regularBlack(int x, int y) {
        return new Spot(x, y, new RegularPiece(false));
    }
    public static Spot emptySpot(int x,int y) {
        return new Spot(x, y, null);
    }
}
