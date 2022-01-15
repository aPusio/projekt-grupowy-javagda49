package com.sda.games.checkers.logic.player;

import com.sda.games.checkers.database.model.MoveEntity;
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
    private String start;
    private String end;
    private Piece pieceMoved;

    public Move(MoveEntity moveEntity) {
        this.player = moveEntity.getPlayer();
        this.start = moveEntity.getStartSpot();
        this.end = moveEntity.getEndSpot();
    }
}