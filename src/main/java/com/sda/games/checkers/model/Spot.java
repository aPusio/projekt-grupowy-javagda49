package com.sda.games.checkers.model;

public class Spot {

    private Piece piece;
    private boolean occupied;

    private int x;
    private int y;

    public Spot(int x, int y, Piece piece, boolean occupied) {
        this.setX(x);
        this.setY(y);
        this.setPiece(piece);
        this.setOccupied(occupied);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
