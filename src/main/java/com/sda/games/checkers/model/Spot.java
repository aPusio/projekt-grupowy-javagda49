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
            if (!board.getBoardSpot(startX, startY).getPiece().isWhite()) {
                System.out.println("Not your piece!");
            } else if (startX == 0 && (board.getBoardSpot(startX + 1, startY + 1).getPiece() != null)) {
                System.out.println("No move available!");
            } else if (startX == 7 && (board.getBoardSpot(startX - 1, startY + 1).getPiece() != null)) {
                System.out.println("No move available!");
            } else if (startX == 7 && (board.getBoardSpot(startX - 1, startY + 1).getPiece() == null)) {
                return true;
            } else if (board.getBoardSpot(startX + 1, startY + 1).getPiece() != null &&
                    board.getBoardSpot(startX - 1, startY + 1).getPiece() != null) {
                if (board.getBoardSpot(startX + 1, startY + 1).getPiece().isWhite() &&
                    board.getBoardSpot(startX - 1, startY + 1).getPiece().isWhite()) {
                    System.out.println("No move available!");
                }
            } else {
                return true;
            }
        } else if (!player.isWhite()) {
            if (board.getBoardSpot(startX, startY).getPiece().isWhite()) {
                System.out.println("Not your piece!");
            } else if (startX == 0 && (board.getBoardSpot(startX + 1, startY - 1).getPiece() != null)) {
                System.out.println("No move available!");
            } else if (startX == 7 && (!board.getBoardSpot(startX - 1, startY - 1).getPiece().isWhite())) {
                System.out.println("No move available!");
            } else if (startX == 7 && (board.getBoardSpot(startX - 1, startY - 1).getPiece() == null)) {
                return true;
            } else if ( startX > 0 && startX < 7 && board.getBoardSpot(startX + 1, startY - 1).getPiece() != null &&
                    board.getBoardSpot(startX - 1, startY - 1).getPiece() != null) {
                if (hasKill(board, player, startX, startY)) {
                    return true;
                }
                System.out.println("No move available!");
                System.out.println("lol");
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
            if (startX - 2 == endX && startY + 2 == endY && !(board.getBoardSpot(startX - 1, startY + 1).getPiece().isWhite())) {
                board.setBoardPieceNull(startX - 1, startY + 1);
                return true;
            } else if ((startX + 2 == endX && startY + 2 == endY) && !(board.getBoardSpot(startX + 1, startY + 1).getPiece().isWhite())) {
                board.setBoardPieceNull(startX + 1, startY + 1);
                return true;
            } else if ((startX - 2 == endX && startY - 2 == endY) && !(board.getBoardSpot(startX - 1, startY - 1).getPiece().isWhite())) {
                board.setBoardPieceNull(startX - 1, startY - 1);
                return true;
            } else if ((startX + 2 == endX && startY - 2 == endY) && !(board.getBoardSpot(startX + 1, startY - 1).getPiece().isWhite())) {
                board.setBoardPieceNull(startX + 1, startY - 1);
                return true;
            }
        } else if (!player.isWhite()) {
            if (startX - 2 == endX && startY + 2 == endY && board.getBoardSpot(startX - 1, startY + 1).getPiece().isWhite()) {
                board.setBoardPieceNull(startX - 1, startY + 1);
                return true;
            } else if ((startX + 2 == endX && startY + 2 == endY) && board.getBoardSpot(startX + 1, startY + 1).getPiece().isWhite()) {
                board.setBoardPieceNull(startX + 1, startY + 1);
                return true;
            } else if ((startX - 2 == endX && startY - 2 == endY) && board.getBoardSpot(startX - 1, startY - 1).getPiece().isWhite()) {
                board.setBoardPieceNull(startX - 1, startY - 1);
                return true;
            } else if ((startX + 2 == endX && startY - 2 == endY) && board.getBoardSpot(startX + 1, startY - 1).getPiece().isWhite()) {
                board.setBoardPieceNull(startX + 1, startY - 1);
                return true;
            }
        }
        return false;
    }

    public boolean hasKill (Board board, Player player, int startX, int startY) throws Exception {
        if (startX > 1 && startY > 1 && startX < 6 && startX < 6) {
            if (player.isWhite()) {
                if (board.getBoardSpot(startX - 2, startY + 2).getPiece() == null &&
                        !board.getBoardSpot(startX - 1, startY + 1).getPiece().isWhite()) {
                    return true;
                } else if (board.getBoardSpot(startX + 2, startY + 2).getPiece() == null &&
                        !board.getBoardSpot(startX + 1, startY + 1).getPiece().isWhite()) {
                    return true;
                } else if (board.getBoardSpot(startX - 2, startY - 2).getPiece() == null &&
                        !board.getBoardSpot(startX - 1, startY - 1).getPiece().isWhite()) {
                    return true;
                } else if (board.getBoardSpot(startX + 2, startY - 2).getPiece() == null &&
                        !board.getBoardSpot(startX + 1, startY - 1).getPiece().isWhite()) {
                    return true;
                }
            } else if (!player.isWhite()) {
                if (board.getBoardSpot(startX - 2, startY + 2).getPiece() == null &&
                        (board.getBoardSpot(startX - 1, startY + 1).getPiece() == null ||
                                board.getBoardSpot(startX - 1, startY + 1).getPiece().isWhite())) {
                    return true;
                } else if (board.getBoardSpot(startX + 2, startY + 2).getPiece() == null &&
                        board.getBoardSpot(startX + 1, startY + 1).getPiece().isWhite()) {
                    return true;
                } else if (board.getBoardSpot(startX - 2, startY - 2).getPiece() == null &&
                        board.getBoardSpot(startX - 1, startY - 1).getPiece().isWhite()) {
                    return true;
                } else if (board.getBoardSpot(startX + 2, startY - 2).getPiece() == null &&
                        board.getBoardSpot(startX + 1, startY - 1).getPiece().isWhite()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
