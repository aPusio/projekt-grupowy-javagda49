package com.sda.games.checkers.model.piece;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UberPiece extends Piece {

    public UberPiece(boolean white) {
        super(white);
    }

    @Override
    public String getPieceIcon() {
        if (white) {
            return "\u25A0";
        } else {
            return "\u25A1";
        }
    }
}
