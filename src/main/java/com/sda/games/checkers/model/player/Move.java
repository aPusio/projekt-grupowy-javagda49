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
            } else if (startX == 0 && board.isNotEmpty(startX + 1, startY + 1)) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 7 && (board.isNotEmpty(startX - 1, startY + 1))) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 7 && (board.isEmpty(startX - 1, startY + 1))) {
                return true;
            } else if (
                    board.isNotEmpty(startX + 1, startY + 1) &&
                            board.isNotEmpty(startX - 1, startY + 1)) {
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
            } else if (startX == 0 && (board.isNotEmpty(startX + 1, startY - 1))) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 7 && (board.isNotEmpty(startX - 1, startY - 1))) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available");
                }
            } else if (startX == 7 && (board.isEmpty(startX - 1, startY - 1))) {
                return true;
            } else if ((startX > 0 && startX < 7) &&
                    board.isNotEmpty(startX + 1, startY - 1) &&
                    board.isNotEmpty(startX - 1, startY - 1)) {
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
        } else if (Move.validateBottomKilling(board, player, startX, startY)) {
            return true;
        }
        return false;
    }

    public static boolean validateExceptionsKilling(Board board, Player player, int startX, int startY) throws Exception {

        if (player.isWhite()) {
            if (startX == 0 && startY == 0) {
                return (board.isEmpty(2, 2) && board.pieceIsBlack(1, 1));
            } else if (startX == 6 && startY == 0) {
                return (board.isEmpty(4, 2) && board.pieceIsBlack(5, 1));
            } else if (startX == 1 && startY == 1) {
                return (board.isEmpty(3, 3) && board.pieceIsBlack(2, 2));
            } else if (startX == 7 && startY == 1) {
                return (board.isEmpty(5, 3) && board.pieceIsBlack(6, 2));
            } else if (startX == 0 && startY == 6) {
                return (board.isEmpty(2, 4) && board.pieceIsBlack(1, 5));
            } else if (startX == 6 && startY == 6) {
                return (board.isEmpty(4, 4) && board.pieceIsBlack(5, 5));
            } else if (startX == 1 && startY == 7) {
                return (board.isEmpty(3, 5) && board.pieceIsBlack(2, 6));
            } else if (startX == 7 && startY == 7) {
                return (board.isEmpty(5, 5) && board.pieceIsBlack(6, 6));
            }
        } else if (!player.isWhite()) {
            if (startX == 0 && startY == 0) {
                return (board.isEmpty(2, 2) && board.pieceIsWhite(1, 1));
            } else if (startX == 6 && startY == 0) {
                return (board.isEmpty(4, 2) && board.pieceIsWhite(5, 1));
            } else if (startX == 1 && startY == 1) {
                return (board.isEmpty(3, 3) && board.pieceIsWhite(2, 2));
            } else if (startX == 7 && startY == 1) {
                return (board.isEmpty(5, 3) && board.pieceIsWhite(6, 2));
            } else if (startX == 0 && startY == 6) {
                return (board.isEmpty(2, 4) && board.pieceIsWhite(1, 5));
            } else if (startX == 6 && startY == 6) {
                return (board.isEmpty(4, 4) && board.pieceIsWhite(5, 5));
            } else if (startX == 1 && startY == 7) {
                return (board.isEmpty(3, 5) && board.pieceIsWhite(2, 6));
            } else if (startX == 7 && startY == 7) {
                return (board.isEmpty(5, 5) && board.pieceIsWhite(6, 6));
            }
        }
        return false;
    }

    public static boolean validateCenterKilling(Board board, Player player, int startX, int startY) throws Exception {
        if (startX > 1 && startY > 1 && startX < 6 && startY < 6) {
            if (player.isWhite()) {
                if (board.isEmpty(startX - 2, startY + 2) &&
                        (board.isNotEmpty(startX - 1, startY + 1) &&
                                board.pieceIsBlack(startX - 1, startY + 1))) {
                    return true;
                } else if (board.isEmpty(startX + 2, startY + 2) &&
                        (board.isNotEmpty(startX + 1, startY + 1) &&
                                board.pieceIsBlack(startX + 1, startY + 1))) {
                    return true;
                } else if (board.isEmpty(startX - 2, startY - 2) &&
                        (board.isNotEmpty(startX - 1, startY - 1) &&
                                board.pieceIsBlack(startX - 1, startY - 1))) {
                    return true;
                } else if (board.isEmpty(startX + 2, startY - 2) &&
                        (board.isNotEmpty(startX + 1, startY - 1) &&
                                board.pieceIsBlack(startX + 1, startY - 1))) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if (board.isEmpty(startX - 2, startY + 2) &&
                        (board.isNotEmpty(startX - 1, startY + 1) &&
                                board.pieceIsWhite(startX - 1, startY + 1))) {
                    return true;
                } else if (board.isEmpty(startX + 2, startY + 2) &&
                        (board.isNotEmpty(startX + 1, startY + 1) &&
                                board.pieceIsWhite(startX + 1, startY + 1))) {
                    return true;
                } else if (board.isEmpty(startX - 2, startY - 2) &&
                        (board.isNotEmpty(startX - 1, startY - 1) &&
                                board.pieceIsWhite(startX - 1, startY - 1))) {
                    return true;
                } else if (board.isEmpty(startX + 2, startY - 2) &&
                        (board.isNotEmpty(startX + 1, startY - 1) &&
                                board.pieceIsWhite(startX + 1, startY - 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateLeftSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startX == 0 && (startY == 2 || startY == 4)) || (startX == 1 && (startY == 3 || startY == 5))) {
            if (player.isWhite()) {
                if ((board.isEmpty(startX + 2, startY + 2) && board.pieceIsBlack(startX + 1, startY + 1)) ||
                        (board.isEmpty(startX + 2, startY - 2) && board.pieceIsBlack(startX + 1, startY - 1))) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if ((board.isEmpty(startX + 2, startY + 2) && board.pieceIsWhite(startX + 1, startY + 1)) ||
                        (board.isEmpty(startX + 2, startY - 2) && board.pieceIsWhite(startX + 1, startY - 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateRightSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startX == 7 && (startY == 3 || startY == 5)) || (startX == 6 && (startY == 2 || startY == 4))){
            if (player.isWhite()) {
                if ((board.isEmpty(startX - 2, startY + 2) && board.pieceIsBlack(startX - 1, startY + 1)) ||
                        (board.isEmpty(startX - 2, startY - 2) && board.pieceIsBlack(startX - 1, startY - 1))) {
                    return true;
                }
            }
            if (!player.isWhite()) {
                if ((board.isEmpty(startX - 2, startY - 2) && board.pieceIsWhite(startX - 1, startY - 1)) ||
                        (board.isEmpty(startX - 2, startY + 2) && board.pieceIsWhite(startX - 1, startY + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateTopKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startY == 7 && (startX == 3 || startX == 5)) || (startY == 6 && (startX == 2 || startX == 4))) {
            if (player.isWhite()) {
                if ((board.isEmpty(startX - 2, startY - 2) && board.pieceIsBlack(startX - 1, startY - 1) ||
                        (board.isEmpty(startX + 2, startY - 2) && board.pieceIsBlack(startX + 1, startY - 1)))) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if ((board.isEmpty(startX - 2, startY - 2) && board.pieceIsWhite(startX - 1, startY - 1) ||
                        (board.isEmpty(startX + 2, startY - 2) && board.pieceIsWhite(startX + 1, startY - 1)))) {
                    return true;
                }
            }
        }
        System.out.println("here");
        return false;
    }

    public static boolean validateBottomKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startY == 0 && (startX == 2 || startX == 4)) || (startY == 1 && (startX == 3 || startX == 5))) {
            if (player.isWhite()) {
                if ((board.isEmpty(startX - 2, startY + 2) && board.pieceIsBlack(startX - 1, startY + 1) ||
                        (board.isEmpty(startX + 2, startY + 2) && board.pieceIsBlack(startX + 1, startY + 1)))) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if ((board.isEmpty(startX - 2, startY + 2) && board.pieceIsWhite(startX - 1, startY + 1) ||
                        (board.isEmpty(startX + 2, startY + 2) && board.pieceIsWhite(startX + 1, startY + 1)))) {
                    return true;
                }
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