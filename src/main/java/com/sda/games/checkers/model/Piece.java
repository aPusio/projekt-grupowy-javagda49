package com.sda.games.checkers.model;

public class Piece {

    private boolean white;
    private boolean regular;

    public Piece(boolean white, boolean regular) {
        this.white = white;
        this.regular = regular;
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
}
