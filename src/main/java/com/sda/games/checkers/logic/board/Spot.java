package com.sda.games.checkers.logic.board;

import com.sda.games.checkers.logic.piece.Piece;
import com.sda.games.checkers.logic.player.Player;
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

    public static boolean validateStartSpot(Board board, Player currentPlayer, int startX, int startY) throws Exception {
        if (board.isEmpty(startX, startY)) {
            System.out.println("Invalid board spot!");
        } else if (board.hasNoPiece(startX, startY)) {
            System.out.println("No checker here!");
        } else if ((currentPlayer.isWhite() && board.pieceIsBlack(startX, startY)) || (currentPlayer.isBlack()) && board.pieceIsWhite(startX, startY)){
            System.out.println("Not your checker!");
        } else return board.getPiece(startX, startY).hasMove(board, currentPlayer, startX, startY);
        return false;
    }

    public boolean checkPrimaryMove(Player player, int startX, int startY, int endX, int endY) {
        if ((player.isWhite() && (startY - endY) != -1) ||
                (player.isBlack() && (startY - endY != 1)) ||
                (startX - endX != -1 && startX - endX != 1)) {
        } else {
            return true;
        }
        return false;
    }

    public boolean isStartSpotValid(Board board, Player player, Piece piece, int startX, int startY) throws Exception {
        if(piece.isRegular()) {
            return piece.hasMove(board, player, startX, startY);
        } else {
            if(piece.hasMove(board, player, startX, startY)){
                return true;
            } else return piece.hasKill(board, player, startX, startY);
        }
    }

    public boolean isEndSpotValid(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        if (board.hasPiece(endX, endY)) {
            System.out.println("Invalid move!");
            return false;
        } else {
            if(board.getPiece(startX,startY).isRegular()) {
                return checkPrimaryMove(player, startX, startY, endX, endY);
            } else {
                return board.getPiece(startX,startY).possiblePrimaryMoves(board,player,startX,startY).contains(String.valueOf(endX) + endY);
            }
        }
    }
}
