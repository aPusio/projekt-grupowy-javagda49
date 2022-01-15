package com.sda.games.checkers.logic.player;

import com.sda.games.checkers.logic.board.Spot;
import com.sda.games.checkers.logic.piece.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Move {
    private Player player;
    private Spot start;
    private Spot end;
    private Piece pieceMoved;

}