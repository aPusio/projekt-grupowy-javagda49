package com.sda.games.checkers.model.board;

import com.sda.games.checkers.model.piece.Piece;
import com.sda.games.checkers.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Spot {

    private int x;
    private int y;
    private Piece piece;

    public boolean checkPrimaryMove(Player player, int startX, int startY, int endX, int endY) {
        return !((player.isWhite() && (startY - endY) != -1) || (player.isBlack() && (startY - endY) != 1) ||
                (startX - endX != -1 && startX - endX != 1));
    }

    public boolean isStartSpotValid(Board board, Player player, Piece piece, int startX, int startY) throws Exception {
        return piece.hasMove(board, player, startX, startY);
    }

    public boolean isEndSpotValid(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        if (board.hasPiece(endX, endY)) {
            System.out.println("Invalid move!");
            return false;
        } else {
            return checkPrimaryMove(player, startX, startY, endX, endY);
        }
    }
}
