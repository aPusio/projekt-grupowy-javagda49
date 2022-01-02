package com.sda.games.checkers.model;

public class Move {
    private Player player;
    public Spot start;
    private Spot end;
    private Piece pieceMoved;
    private Piece pieceKilled;

    public Move(Player player, Spot start, Spot end, Piece pieceMoved) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }
}
