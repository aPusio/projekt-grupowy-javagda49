package com.sda.games.checkers.model.piece;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class RegularPiece extends Piece{

    public RegularPiece(boolean white) {
        super(white);
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
