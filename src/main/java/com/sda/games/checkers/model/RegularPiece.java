package com.sda.games.checkers.model;

public class RegularPiece extends Piece{

    public RegularPiece(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (!(end.getPiece() == null)) {
            return false;
        }

        return true;
    }
}
