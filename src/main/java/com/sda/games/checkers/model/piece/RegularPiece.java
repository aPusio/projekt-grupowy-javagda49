package com.sda.games.checkers.model.piece;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class RegularPiece extends Piece{
    private final boolean REGULAR = true;

    public RegularPiece(boolean white) {
        super(white);
    }


    @Override
    public boolean isRegular() {
        return REGULAR;
    }

    @Override
    public String getPieceIcon() {
        if (white) {
            return "\u25CF";
        } else {
            return "\u2B58";
        }
    }
}
