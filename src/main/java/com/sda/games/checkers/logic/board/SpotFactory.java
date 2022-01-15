package com.sda.games.checkers.logic.board;

import com.sda.games.checkers.logic.piece.RegularPiece;
import com.sda.games.checkers.logic.piece.UberPiece;

public class SpotFactory {
    public static Spot regularWhite(int x, int y) {
        return new Spot(x, y, new RegularPiece(true));
    }
    public static Spot regularBlack(int x, int y) {
        return new Spot(x, y, new RegularPiece(false));
    }
    public static Spot uberWhite(int x, int y) {
        return new Spot(x, y, new UberPiece(true));
    }
    public static Spot uberBlack(int x, int y) {
        return new Spot(x, y, new UberPiece(false));
    }
    public static Spot emptySpot(int x,int y) {
        return new Spot(x, y, null);
    }
}
