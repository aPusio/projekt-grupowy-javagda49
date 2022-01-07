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

//    public boolean pieceIsWhite(Board board, int x, int y) throws Exception {
//        return hasPiece(board, x, y) && board.getBoardSpot(x, y).getPiece().isWhite();
//    }
//
//    public boolean pieceIsBlack(Board board, int x, int y) throws Exception {
//        return hasPiece(board, x, y) && !pieceIsWhite(board, x, y);
//    }
//
//    public boolean hasPiece(Board board, int x, int y) throws Exception {
//        return board.getBoardSpot(x, y).getPiece() != null;
//    }
//
//    public boolean hasNoPiece(Board board, int x, int y) throws Exception {
//        return !hasPiece(board, x, y);
//    }

    public boolean isStartSpotValid(Board board, Player player, int startX, int startY) throws Exception {
        return Piece.hasMove(board, player, startX, startY);
    }

    public boolean isEndSpotValid(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        if (board.hasPiece(endX, endY)) {
            System.out.println("Invalid move!");
            return false;
        }

        return checkPrimaryMove(player, startX, startY, endX, endY);
    }

    public boolean checkPrimaryMove(Player player, int startX, int startY, int endX, int endY) {
        if ((player.isWhite() && (startY - endY) != -1) ||
                (player.isBlack() && (startY - endY != 1)) ||
                (startX - endX != -1 && startX - endX != 1)) {
            System.out.println("Invalid move!");
        } else {
            return true;
        }
        return false;
    }
}
