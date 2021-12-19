package com.sda.games.checkers.model;

public class Board {

    private final static int BORDER_SIZE = 8;
    private Spot[][] boardSpots = new Spot[BORDER_SIZE][BORDER_SIZE];

    public Spot getBoardSpot (int x, int y) throws Exception {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Space is out of bounds");
        }
        return boardSpots[x][y];
    }
}
