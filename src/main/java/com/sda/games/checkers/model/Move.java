package com.sda.games.checkers.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Move {
    private Player player;
    private Spot start;
    private Spot end;
    private Piece pieceMoved;

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
                if ((board.isNotEmpty(startX - 2, startY - 2) && board.pieceIsBlack(startX - 1, startY - 1) ||
                        (board.isNotEmpty(startX + 2, startY - 2) && board.pieceIsBlack(startX + 1, startY - 1)))) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if ((board.isNotEmpty(startX - 2, startY - 2) && board.pieceIsWhite(startX - 1, startY - 1) ||
                        (board.isNotEmpty(startX + 2, startY - 2) && board.pieceIsWhite(startX + 1, startY - 1)))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateBottomKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startY == 0 && (startX == 2 || startY == 4)) || (startY == 1 && (startX == 3 || startX == 5))) {
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
}