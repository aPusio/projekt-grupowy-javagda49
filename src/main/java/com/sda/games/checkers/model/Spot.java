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
            if (board.pieceIsBlack(startX, startY)) {
                System.out.println("Not your piece!");
                return false;
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
            } else if ((startX > 0 && startX < 7) &&
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

    public boolean hasKill(Board board, Player player, int startX, int startY) throws Exception {
//        Validate exceptions killing
        if (Move.validateExceptionsKilling(board, player, startX, startY)) {
            return true;
//         Validate center killing
        } else if (Move.validateCenterKilling(board, player, startX, startY)) {
            return true;
//          Validate left side killing
        } else if (Move.validateLeftSideKilling(board, player, startX, startY)) {
            return true;
//          Validate right side killing
        } else if (Move.validateRightSideKilling(board, player, startX, startY)) {
            return true;
//          Validate top killing
        } else if (Move.validateTopKilling(board, player, startX, startY)) {
            return true;
//            Validate bottom killing
        } else if (Move.validateBottomKilling(board, player, startX, startY)) {
            return true;
        }
        return false;
    }
}
