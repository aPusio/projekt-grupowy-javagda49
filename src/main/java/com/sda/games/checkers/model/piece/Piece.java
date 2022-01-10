package com.sda.games.checkers.model.piece;

import com.sda.games.checkers.model.board.Board;
import com.sda.games.checkers.model.player.Move;
import com.sda.games.checkers.model.player.Player;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Piece {

    public boolean white;
    private boolean regular;
    private boolean killed;
    private String pieceIcon;

    public String getPieceIcon() {
        return this.pieceIcon;
    }

    public Piece(boolean white) {
        this.white = white;
    }

    public abstract boolean isRegular();

    public static boolean hasMove(Board board, Player player, int startX, int startY) throws Exception {
        if (player.isWhite()) {
            if (board.pieceIsBlack(startX, startY)) {
                System.out.println("Not your piece!");
                return false;
            } else if (startY == 7) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 0 && board.hasPiece(startX + 1, startY + 1)) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 7 && (board.hasPiece(startX - 1, startY + 1))) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 7 && (board.hasNoPiece(startX - 1, startY + 1))) {
                return true;
            } else if (
                    board.hasPiece(startX + 1, startY + 1) &&
                            board.hasPiece(startX - 1, startY + 1)) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else {
                return true;
            }
        } else if (!player.isWhite()) {
            if (board.pieceIsWhite(startX, startY)) {
                System.out.println("Not your piece!");
                return false;
            } else if (startY == 0) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 0 && (board.hasPiece(startX + 1, startY - 1))) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 7 && (board.hasPiece(startX - 1, startY - 1))) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available");
                }
            } else if (startX == 7 && (board.hasNoPiece(startX - 1, startY - 1))) {
                return true;
            } else if ((startX > 0 && startX < 7) &&
                    board.hasPiece(startX + 1, startY - 1) &&
                    board.hasPiece(startX - 1, startY - 1)) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                }
                System.out.println("No move available!");
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean hasKill(Board board, Player player, int startX, int startY) throws Exception {
        if (Move.validateExceptionsKilling(board, player, startX, startY)) {
            return true;
        } else if (Move.validateCenterKilling(board, player, startX, startY)) {
            return true;
        } else if (Move.validateLeftSideKilling(board, player, startX, startY)) {
            return true;
        } else if (Move.validateRightSideKilling(board, player, startX, startY)) {
            return true;
        } else if (Move.validateTopKilling(board, player, startX, startY)) {
            return true;
        } else return Move.validateBottomKilling(board, player, startX, startY);
    }

}
