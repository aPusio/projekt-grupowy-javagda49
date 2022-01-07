package com.sda.games.checkers.model.player;

import com.sda.games.checkers.model.board.Board;
import com.sda.games.checkers.model.board.Spot;
import com.sda.games.checkers.model.piece.Piece;
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

    private static boolean upLeftKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        if (board.hasNoPiece(startX - 2, startY + 2)) {
            if (isPlayerWhite) {
                return board.pieceIsBlack(startX - 1, startY + 1);
            } else {
                return board.pieceIsWhite(startX - 1, startY + 1);
            }
        }
        return false;
    }

    private static boolean upRightKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        if (board.hasNoPiece(startX + 2, startY + 2)) {
            if (isPlayerWhite) {
                return board.pieceIsBlack(startX + 1, startY + 1);
            } else {
                return board.pieceIsWhite(startX + 1, startY + 1);
            }
        }
        return false;
    }

    private static boolean downLeftKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        if (board.hasNoPiece(startX - 2, startY - 2)) {
            if (isPlayerWhite) {
                return board.pieceIsBlack(startX - 1, startY - 1);
            } else {
                return board.pieceIsWhite(startX - 1, startY - 1);
            }
        }
        return false;
    }

    private static boolean downRightKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        if (board.hasNoPiece(startX + 2, startY - 2)) {
            if (isPlayerWhite) {
                return board.pieceIsBlack(startX + 1, startY - 1);
            } else {
                return board.pieceIsWhite(startX + 1, startY - 1);
            }
        }
        return false;
    }

    public static boolean validateExceptionsKilling(Board board, Player player, int startX, int startY) throws Exception {

        if (player.isWhite()) {
            if (startX == 0 && startY == 0) {
                return (board.hasNoPiece(2, 2) && board.pieceIsBlack(1, 1));
            } else if (startX == 6 && startY == 0) {
                return (board.hasNoPiece(4, 2) && board.pieceIsBlack(5, 1));
            } else if (startX == 1 && startY == 1) {
                return (board.hasNoPiece(3, 3) && board.pieceIsBlack(2, 2));
            } else if (startX == 7 && startY == 1) {
                return (board.hasNoPiece(5, 3) && board.pieceIsBlack(6, 2));
            } else if (startX == 0 && startY == 6) {
                return (board.hasNoPiece(2, 4) && board.pieceIsBlack(1, 5));
            } else if (startX == 6 && startY == 6) {
                return (board.hasNoPiece(4, 4) && board.pieceIsBlack(5, 5));
            } else if (startX == 1 && startY == 7) {
                return (board.hasNoPiece(3, 5) && board.pieceIsBlack(2, 6));
            } else if (startX == 7 && startY == 7) {
                return (board.hasNoPiece(5, 5) && board.pieceIsBlack(6, 6));
            }
        } else if (!player.isWhite()) {
            if (startX == 0 && startY == 0) {
                return (board.hasNoPiece(2, 2) && board.pieceIsWhite(1, 1));
            } else if (startX == 6 && startY == 0) {
                return (board.hasNoPiece(4, 2) && board.pieceIsWhite(5, 1));
            } else if (startX == 1 && startY == 1) {
                return (board.hasNoPiece(3, 3) && board.pieceIsWhite(2, 2));
            } else if (startX == 7 && startY == 1) {
                return (board.hasNoPiece(5, 3) && board.pieceIsWhite(6, 2));
            } else if (startX == 0 && startY == 6) {
                return (board.hasNoPiece(2, 4) && board.pieceIsWhite(1, 5));
            } else if (startX == 6 && startY == 6) {
                return (board.hasNoPiece(4, 4) && board.pieceIsWhite(5, 5));
            } else if (startX == 1 && startY == 7) {
                return (board.hasNoPiece(3, 5) && board.pieceIsWhite(2, 6));
            } else if (startX == 7 && startY == 7) {
                return (board.hasNoPiece(5, 5) && board.pieceIsWhite(6, 6));
            }
        }
        return false;
    }

    public static boolean validateCenterKilling(Board board, Player player, int startX, int startY) throws Exception {
        if (startX > 1 && startY > 1 && startX < 6 && startY < 6) {
            if (upLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else if (upRightKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else if (downLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else if (downRightKill(board, player.isWhite(), startX, startY)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateLeftSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startX == 0 && (startY == 2 || startY == 4)) || (startX == 1 && (startY == 3 || startY == 5))) {
            if (upRightKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else if (downRightKill(board, player.isWhite(), startX, startY)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateRightSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startX == 7 && (startY == 3 || startY == 5)) || (startX == 6 && (startY == 2 || startY == 4))) {
            if (upLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else if (downLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateTopKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startY == 7 && (startX == 3 || startX == 5))
                || (startY == 6 && (startX == 2 || startX == 4))) {
            if (downLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else if (downRightKill(board, player.isWhite(), startX, startY)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateBottomKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startY == 0 && (startX == 2 || startX == 4)) || (startY == 1 && (startX == 3 || startX == 5))) {
            if (upRightKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else if (upLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            }
        }
        return false;
    }

    public static boolean killEnemyPiece(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        if (player.isWhite()) {
            if (startX - 2 == endX && startY + 2 == endY && board.pieceIsBlack(startX - 1, startY + 1)) {
                board.setBoardPieceNull(startX - 1, startY + 1);
                return true;
            } else if ((startX + 2 == endX && startY + 2 == endY) && board.pieceIsBlack(startX + 1, startY + 1)) {
                board.setBoardPieceNull(startX + 1, startY + 1);
                return true;
            } else if ((startX - 2 == endX && startY - 2 == endY) && board.pieceIsBlack(startX - 1, startY - 1)) {
                board.setBoardPieceNull(startX - 1, startY - 1);
                return true;
            } else if ((startX + 2 == endX && startY - 2 == endY) && board.pieceIsBlack(startX + 1, startY - 1)) {
                board.setBoardPieceNull(startX + 1, startY - 1);
                return true;
            }
        } else if (!player.isWhite()) {
            if (startX - 2 == endX && startY + 2 == endY && board.pieceIsWhite(startX - 1, startY + 1)) {
                board.setBoardPieceNull(startX - 1, startY + 1);
                return true;
            } else if ((startX + 2 == endX && startY + 2 == endY) && board.pieceIsWhite(startX + 1, startY + 1)) {
                board.setBoardPieceNull(startX + 1, startY + 1);
                return true;
            } else if ((startX - 2 == endX && startY - 2 == endY) && board.pieceIsWhite(startX - 1, startY - 1)) {
                board.setBoardPieceNull(startX - 1, startY - 1);
                return true;
            } else if ((startX + 2 == endX && startY - 2 == endY) && board.pieceIsWhite(startX + 1, startY - 1)) {
                board.setBoardPieceNull(startX + 1, startY - 1);
                return true;
            }
        }
        return false;
    }
}