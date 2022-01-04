package com.sda.games.checkers.model;

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
        if (player.isWhite()) {
            if (!board.spotIsWhite(startX, startY)) {
                System.out.println("Not your piece!");
                return false;
            } else if (startX == 0 && board.spotHasPiece(startX + 1, startY + 1)) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 7 && (board.spotHasPiece(startX - 1, startY + 1))) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 7 && (!board.spotHasPiece(startX - 1, startY + 1))) {
                return true;
            } else if (
                    board.spotHasPiece(startX + 1, startY + 1) &&
                            board.spotHasPiece(startX - 1, startY + 1)) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else {
                return true;
            }
        } else if (!player.isWhite()) {
            if (board.spotIsWhite(startX, startY)) {
                System.out.println("Not your piece!");
                return false;
            } else if (startX == 0 && (board.spotHasPiece(startX + 1, startY - 1))) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available!");
                }
            } else if (startX == 7 && (board.spotHasPiece(startX - 1, startY - 1))) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                } else {
                    System.out.println("No move available");
                }
            } else if (startX == 7 && (!board.spotHasPiece(startX - 1, startY - 1))) {
                return true;
            } else if (startX > 0 && startX < 7 && board.spotHasPiece(startX + 1, startY - 1) &&
                    board.spotHasPiece(startX - 1, startY - 1)) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                }
                System.out.println("No move available!");
//                Check if start checker has kill
            } else if (hasKill(board, player, startX, startY)) {
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isEndSpotValid(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        if (board.getBoardSpot(endX, endY).getPiece() != null) {
            System.out.println("Invalid move! (Piece on destination)");
            return false;
        }

        if (killEnemyPiece(board, player, startX, startY, endX, endY)) {
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

    public boolean killEnemyPiece(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        if (player.isWhite()) {
            if (startX - 2 == endX && startY + 2 == endY && !(board.spotIsWhite(startX - 1, startY + 1))) {
                board.setBoardPieceNull(startX - 1, startY + 1);
                return true;
            } else if ((startX + 2 == endX && startY + 2 == endY) && !(board.spotIsWhite(startX + 1, startY + 1))) {
                board.setBoardPieceNull(startX + 1, startY + 1);
                return true;
            } else if ((startX - 2 == endX && startY - 2 == endY) && !(board.spotIsWhite(startX - 1, startY - 1))) {
                board.setBoardPieceNull(startX - 1, startY - 1);
                return true;
            } else if ((startX + 2 == endX && startY - 2 == endY) && !(board.spotIsWhite(startX + 1, startY - 1))) {
                board.setBoardPieceNull(startX + 1, startY - 1);
                return true;
            }
        } else if (!player.isWhite()) {
            if (startX - 2 == endX && startY + 2 == endY && board.spotIsWhite(startX - 1, startY + 1)) {
                board.setBoardPieceNull(startX - 1, startY + 1);
                return true;
            } else if ((startX + 2 == endX && startY + 2 == endY) && board.spotIsWhite(startX + 1, startY + 1)) {
                board.setBoardPieceNull(startX + 1, startY + 1);
                return true;
            } else if ((startX - 2 == endX && startY - 2 == endY) && board.spotIsWhite(startX - 1, startY - 1)) {
                board.setBoardPieceNull(startX - 1, startY - 1);
                return true;
            } else if ((startX + 2 == endX && startY - 2 == endY) && board.spotIsWhite(startX + 1, startY - 1)) {
                board.setBoardPieceNull(startX + 1, startY - 1);
                return true;
            }
        }
        return false;
    }

    public boolean hasKill(Board board, Player player, int startX, int startY) throws Exception {
//         Validate center killing
        if (Move.validateCenterKilling(board, player, startX, startY)) {
            return true;
//          Validate left side killing
        } else if (Move.validateLeftSideKilling(board, player, startX, startY)) {
            return true;
//          Validate right side killing
        } else if (Move.validateRightSideKilling(board, player, startX, startY)) {
            return true;
//          Validate row 7
        } else if (startY == 6 && (startX == 2 || startX == 4)) {
            if (player.isWhite()) {
                if ((board.spotHasPiece(startX - 2, startY - 2) && !board.spotIsWhite(startX - 1, startY - 1) ||
                        (board.spotHasPiece(startX + 2, startY - 2) && !board.spotIsWhite(startX + 1, startY - 1)))) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if ((board.spotHasPiece(startX - 2, startY - 2) && board.spotIsWhite(startX - 1, startY - 1) ||
                        (board.spotHasPiece(startX + 2, startY - 2) && board.spotIsWhite(startX + 1, startY - 1)))) {
                    return true;
                }
            }
//            Validate row 2
        } else if ((startY == 1 && (startX == 3 || startX == 5))) {
            if (player.isWhite()) {
                if ((!board.spotHasPiece(startX - 2, startY + 2) && !board.spotIsWhite(startX - 1, startY + 1) ||
                        (!board.spotHasPiece(startX + 2, startY + 2) && !board.spotIsWhite(startX + 1, startY + 1)))) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if ((!board.spotHasPiece(startX - 2, startY + 2) && board.spotIsWhite(startX - 1, startY + 1) ||
                        (!board.spotHasPiece(startX + 2, startY + 2) && board.spotIsWhite(startX + 1, startY + 1)))) {
                    return true;
                }
            }
//        } else if (startX == 0 && startY == 0) {
//        } else if (startX == 6 && startY == 0) {
//        } else if (startX == 1 && startY == 1) {
//        } else if (startX == 7 && startY == 1) {
//        } else if (startX == 0 && startY == 6) {
//        } else if (startX == 6 && startY == 6) {
//        } else if (startX == 1 && startY == 7) {
//        } else if (startX == 7 && startY == 7) {

        } else if (startX == 6 && startY == 6) {
            if (!player.isWhite()) {
                if (!board.spotHasPiece(4, 4) && board.spotIsWhite(5, 5)) {
                    return true;
                }
            }
        }
        return false;
    }
}
