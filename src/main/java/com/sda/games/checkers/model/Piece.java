package com.sda.games.checkers.model;

public abstract class Piece {

    private boolean white;
    private boolean regular;
    private boolean killed;
    private String pieceIcon;

    public String getPieceIcon() {
        if (this.white && this.regular) {
            return "\u25A0";
        } else if (!this.white && this.regular){
            return "\u25A1";
        } else if (this.white) {
            return "\u25CF";
        } else
            return "\u2B58";
    }

    public void setPieceIcon(String pieceIcon) {
        this.pieceIcon = pieceIcon;
    }

    public Piece(boolean white) {
        this.setWhite(white);
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isRegular() {
        return regular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);
}
