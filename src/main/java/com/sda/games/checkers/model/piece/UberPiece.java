package com.sda.games.checkers.model.piece;

import com.sda.games.checkers.model.board.Board;
import com.sda.games.checkers.model.board.Spot;
import com.sda.games.checkers.model.player.Player;
import lombok.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class UberPiece extends Piece {
    private final boolean REGULAR = false;

    public UberPiece(boolean white) {
        super(white);
    }

    @Override
    public boolean isRegular() {
        return REGULAR;
    }

    @Override
    public String getPieceIcon() {
        if (white) {
            return "\u25A0";
        } else {
            return "\u25A1";
        }
    }

    @Override
    public boolean hasMove(Board board, Player player, int startX, int startY) throws Exception {
        if (player.isWhite()) {
            if (board.pieceIsBlack(startX, startY)) {
                System.out.println("Not your piece!");
                return false;
            } else {
                return isMovePossibleAndPrintPossible(board, player, startX, startY);
            }
//            } else if (!upLeftMove(board, player, startX, startY).isEmpty()) {
//                return true;
//            } else if (!downRightMove(board, player, startX, startY).isEmpty()) {
//                return true;
//            } else if (!downLeftMove(board, player, startX, startY).isEmpty()) {
//                return true;
//            } else {
//                return false;
//            }

//            } else if (startY == 7) {
//                if (hasKill(board, player, startX, startY)) {
//                    return true;
//                } else {
//                    System.out.println("No move available!");
//                }
//            } else if (startX == 0 && board.hasPiece(startX + 1, startY + 1)) {
//                if (hasKill(board, player, startX, startY)) {
//                    return true;
//                } else {
//                    System.out.println("No move available!");
//                }
//            } else if (startX == 7 && (board.hasPiece(startX - 1, startY + 1))) {
//                if (hasKill(board, player, startX, startY)) {
//                    return true;
//                } else {
//                    System.out.println("No move available!");
//                }
//            } else if (startX == 7 && (board.hasNoPiece(startX - 1, startY + 1))) {
//                return true;
//            } else if (
//                    board.hasPiece(startX + 1, startY + 1) &&
//                            board.hasPiece(startX - 1, startY + 1)) {
//                if (hasKill(board, player, startX, startY)) {
//                    return true;
//                } else {
//                    System.out.println("No move available!");
//                }
        } else if (!player.isWhite()) {
            if (board.pieceIsWhite(startX, startY)) {
                System.out.println("Not your piece!");
                return false;
//            } else if (startY == 0) {
//                if (hasKill(board, player, startX, startY)) {
//                    return true;
//                } else {
//                    System.out.println("No move available!");
//                }
//            } else if (startX == 0 && (board.hasPiece(startX + 1, startY - 1))) {
//                if (hasKill(board, player, startX, startY)) {
//                    return true;
//                } else {
//                    System.out.println("No move available!");
//                }
//            } else if (startX == 7 && (board.hasPiece(startX - 1, startY - 1))) {
//                if (hasKill(board, player, startX, startY)) {
//                    return true;
//                } else {
//                    System.out.println("No move available");
//                }
//            } else if (startX == 7 && (board.hasNoPiece(startX - 1, startY - 1))) {
//                return true;
//            } else if ((startX > 0 && startX < 7) &&
//                    board.hasPiece(startX + 1, startY - 1) &&
//                    board.hasPiece(startX - 1, startY - 1)) {
//                if (hasKill(board, player, startX, startY)) {
//                    return true;
//                }
//                System.out.println("No move available!");
//            } else if (!upRightMove(board, player, startX, startY).isEmpty()) {
//                return true;
//            } else if (!upLeftMove(board, player, startX, startY).isEmpty()) {
//                return true;
//            } else if (!downRightMove(board, player, startX, startY).isEmpty()) {
//                return true;
//            } else if (!downLeftMove(board, player, startX, startY).isEmpty()) {
//                return true;
//            } else {
//                return false;
//            }
            } else {
                return isMovePossibleAndPrintPossible(board, player, startX, startY);
            }
        }
        return false;
    }

    public boolean isMovePossibleAndPrintPossible(Board board, Player player, int startX, int startY) throws Exception {
        Map<Integer, Integer> upRightMoves = upRightMove(board, player, startX, startY);
        Map<Integer, Integer> upLeftMoves = upLeftMove(board, player, startX, startY);
        Map<Integer, Integer> downRightMoves = downRightMove(board, player, startX, startY);
        Map<Integer, Integer> downLeftMoves = downLeftMove(board, player, startX, startY);
        if (!upRightMoves.isEmpty() || !upLeftMoves.isEmpty() || !downRightMoves.isEmpty() || !downLeftMoves.isEmpty()) {
            return true;
        }
        return false;
    }

    public Map<Integer, Integer> upRightMove(Board board, Player player, int startX, int startY) throws Exception {
        Map<Integer, Integer> possibleMoves = new HashMap<>();
        if (startX == 7 || startY == 7) {
            return possibleMoves;
        } else {
            for (int i = 1; i < 7 && startY + i <= 7; i++) {
                if (i < 2) {
                    if (board.hasNoPiece(startX + i, startY + i)) {
                        possibleMoves.put(startX + i, startY + i);
                    }
                } else {
                    if (possibleMoves.containsKey(startX + i - 1) && board.hasNoPiece(startX + i, startY + i)) {
                        possibleMoves.put(startX + i, startY + i);
                    }
                }
            }
            System.out.println("Up Right Move");
            possibleMoves.forEach((k, v) -> {
                System.out.format("key: %s, value: %d%n", k, v);
            });
        }
        return possibleMoves;
    }

    public Map<Integer, Integer> upLeftMove(Board board, Player player, int startX, int startY) throws Exception {
        Map<Integer, Integer> possibleMoves = new HashMap<>();
        if (startX == 0 || startY == 7) {
            return possibleMoves;
        } else {
            for (int i = 1; i < 7 && startY + i <= 7; i++) {
                if (i < 2) {
                    if (board.hasNoPiece(startX - i, startY + i)) {
                        possibleMoves.put(startX - i, startY + i);
                    }
                } else {
                    if (possibleMoves.containsKey(startX - i + 1) && board.hasNoPiece(startX - i, startY + i)) {
                        possibleMoves.put(startX - i, startY + i);
                    }
                }
            }
            System.out.println("Up Left Move");
            possibleMoves.forEach((k, v) -> {
                System.out.format("key: %s, value: %d%n", k, v);
            });
        }
        return possibleMoves;
    }

    public Map<Integer, Integer> downRightMove(Board board, Player player, int startX, int startY) throws Exception {
        Map<Integer, Integer> possibleMoves = new HashMap<>();
        if (startX == 7 || startY == 0) {
            return possibleMoves;
        } else {
            for (int i = 1; i < 7 && startY - i >= 0; i++) {
                if (i < 2) {
                    if (board.hasNoPiece(startX + i, startY - i)) {
                        possibleMoves.put(startX + i, startY - i);
                    }
                } else {
                    if (possibleMoves.containsKey(startX + i - 1) && board.hasNoPiece(startX + i, startY - i)) {
                        possibleMoves.put(startX + i, startY - i);
                    }
                }
            }
            System.out.println("Down Right Move");
            possibleMoves.forEach((k, v) -> {
                System.out.format("key: %s, value: %d%n", k, v);
            });
        }
        return possibleMoves;
    }

    public Map<Integer, Integer> downLeftMove(Board board, Player player, int startX, int startY) throws Exception {
        Map<Integer, Integer> possibleMoves = new HashMap<>();
        if (startX == 0 || startY == 0) {
            return possibleMoves;
        } else {
            for (int i = 1; i < 7 && startY - i >= 0; i++) {
                if (i < 2) {
                    if (board.hasNoPiece(startX - i, startY - i)) {
                        possibleMoves.put(startX - i, startY - i);
                    }
                } else {
                    if (possibleMoves.containsKey(startX - i + 1) && board.hasNoPiece(startX - i, startY - i)) {
                        possibleMoves.put(startX - i, startY - i);
                    }
                }
            }
            System.out.println("Down Left Move");
            possibleMoves.forEach((k, v) -> {
                System.out.format("key: %s, value: %d%n", k, v);
            });
        }
        return possibleMoves;
    }
}
