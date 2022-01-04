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

    public static boolean validateCenterKilling(Board board, Player player, int startX, int startY) throws Exception {
        if (startX > 1 && startY > 1 && startX < 6 && startY < 6) {
            if (player.isWhite()) {
                if (!board.spotHasPiece(startX - 2, startY + 2) &&
                        (!board.spotHasPiece(startX - 1, startY + 1) ||
                                !board.spotIsWhite(startX - 1, startY + 1))) {
                    return true;
                } else if (!board.spotHasPiece(startX + 2, startY + 2) &&
                        (!board.spotHasPiece(startX + 1, startY + 1) ||
                                !board.spotIsWhite(startX + 1, startY + 1))) {
                    return true;
                } else if (!board.spotHasPiece(startX - 2, startY - 2) &&
                        (!board.spotHasPiece(startX - 1, startY - 1) ||
                                !board.spotIsWhite(startX - 1, startY - 1))) {
                    return true;
                } else if (!board.spotHasPiece(startX + 2, startY - 2) &&
                        (!board.spotHasPiece(startX + 1, startY - 1) ||
                                !board.spotIsWhite(startX + 1, startY - 1))) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if (!board.spotHasPiece(startX - 2, startY + 2) &&
                        (!board.spotHasPiece(startX - 1, startY + 1) ||
                                board.spotIsWhite(startX - 1, startY + 1))) {
                    return true;
                } else if (!board.spotHasPiece(startX + 2, startY + 2) &&
                        (!board.spotHasPiece(startX + 1, startY + 1) ||
                                board.spotIsWhite(startX + 1, startY + 1))) {
                    return true;
                } else if (!board.spotHasPiece(startX - 2, startY - 2) &&
                        (!board.spotHasPiece(startX - 1, startY - 1) ||
                                board.spotIsWhite(startX - 1, startY - 1))) {
                    return true;
                } else if (!board.spotHasPiece(startX + 2, startY - 2) &&
                        (!board.spotHasPiece(startX + 1, startY - 1) ||
                                board.spotIsWhite(startX + 1, startY - 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateLeftSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        if (startX == 0 && (startY == 2 || startY == 4)) {
            if (player.isWhite()) {
                if ((!board.spotHasPiece(startX + 2, startY + 2) && !board.spotIsWhite(startX + 1, startY + 1)) ||
                        (!board.spotHasPiece(startX + 2, startY - 2) && !board.spotIsWhite(startX + 1, startY - 1))) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if ((!board.spotHasPiece(startX + 2, startY + 2) && board.spotIsWhite(startX + 1, startY + 1)) ||
                        (!board.spotHasPiece(startX + 2, startY - 2) && board.spotIsWhite(startX + 1, startY - 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateRightSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        if (player.isWhite()) {
            if ((!board.spotHasPiece(startX - 2, startY + 2) && !board.spotIsWhite(startX - 1, startY + 1)) ||
                    (!board.spotHasPiece(startX - 2, startY - 2) && !board.spotIsWhite(startX - 1, startY - 1))) {
                return true;
            }
        }
        if (!player.isWhite()) {
            if ((!board.spotHasPiece(startX - 2, startY - 2) && board.spotIsWhite(startX - 1, startY - 1)) ||
                    (!board.spotHasPiece(startX - 2, startY + 2) && board.spotIsWhite(startX - 1, startY + 1))) {
                return true;
            }
        }
        return false;
    }
}