package com.sda.games.checkers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Piece(boolean white) {
        this.white = white;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);
}
