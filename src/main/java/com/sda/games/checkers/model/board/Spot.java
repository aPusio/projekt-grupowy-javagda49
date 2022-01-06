package com.sda.games.checkers.model.board;

import com.sda.games.checkers.model.player.Move;
import com.sda.games.checkers.model.player.Player;
import com.sda.games.checkers.model.piece.Piece;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Spot {

    private int x;
    private int y;
    private Piece piece;

    public boolean isStartSpotValid(Board board, Player player, int startX, int startY) throws Exception {
        return Move.hasMove(board, player, startX, startY);
    }

    public boolean isEndSpotValid(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        if (board.getBoardSpot(endX, endY).getPiece() != null) {
            System.out.println("Invalid move! (Piece on destination)");
            return false;
        }

        if (Move.killEnemyPiece(board, player, startX, startY, endX, endY)) {
            player.killCounter();
            return true;
        }

        if (player.isWhite() && (startY - endY) != -1) {
            System.out.println("Invalid move!");
        } else if (!player.isWhite() && (startY - endY != 1)) {
            System.out.println("Invalid move!");
        } else if (startX - endX != -1 && startX - endX != 1) {
            System.out.println("Invalid move!");
        } else {
            return true;
        }
        return false;
    }
}
