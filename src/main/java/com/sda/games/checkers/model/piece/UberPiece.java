package com.sda.games.checkers.model.piece;

import com.sda.games.checkers.model.board.Board;
import com.sda.games.checkers.model.board.Spot;
import com.sda.games.checkers.model.player.Player;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

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
                return !possiblePrimaryMoves(board, player, startX, startY).isEmpty();
            }

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
                return !possiblePrimaryMoves(board, player, startX, startY).isEmpty();
            }
        }
        return false;
    }

    public List<String> possiblePrimaryMoves(Board board, Player player, int startX, int startY) throws Exception {
        List<String> allPossibleMoves = new ArrayList<>();
        allPossibleMoves.addAll(upRightMove(board, player, startX, startY));
        allPossibleMoves.addAll(upLeftMove(board, player, startX, startY));
        allPossibleMoves.addAll(downRightMove(board, player, startX, startY));
        allPossibleMoves.addAll(downLeftMove(board, player, startX, startY));
        allPossibleMoves.forEach(System.out::println);
        return allPossibleMoves;
    }

    public List<String> upRightMove(Board board, Player player, int startX, int startY) throws Exception {
        List<String> possibleMoves = new ArrayList<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder previousMove = new StringBuilder();
        if (startX == 7 || startY == 7) {
            return possibleMoves;
        } else {
            for (int i = 1; i < 7 && startY + i <= 7; i++) {
                actualMove.setLength(0);
                if (i < 2) {
                    if (board.hasNoPiece(startX + i, startY + i)) {
                        possibleMoves.add(actualMove.append(startX + i).append(startY + i).toString());
                    }
                } else {
                    if (possibleMoves.contains(previousMove.toString()) && board.hasNoPiece(startX + i, startY + i)) {
                        possibleMoves.add(actualMove.append(startX + i).append(startY + i).toString());
                    }
                }
                previousMove.setLength(0);
                previousMove.append(actualMove);
            }
            return possibleMoves;
        }
    }

    public List<String> upLeftMove(Board board, Player player, int startX, int startY) throws Exception {
        List<String> possibleMoves = new ArrayList<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder previousMove = new StringBuilder();
        if (startX == 0 || startY == 7) {
            return possibleMoves;
        } else {
            for (int i = 1; i < 7 && startY + i <= 7; i++) {
                actualMove.setLength(0);
                if (i < 2) {
                    if (board.hasNoPiece(startX - i, startY + i)) {
                        possibleMoves.add(actualMove.append(startX - i).append( startY + i).toString());
                    }
                } else {
                    if (possibleMoves.contains(previousMove.toString()) && board.hasNoPiece(startX - i, startY + i)) {
                        possibleMoves.add(actualMove.append(startX - i).append( startY + i).toString());
                    }
                }
                previousMove.setLength(0);
                previousMove.append(actualMove);
            }
            return possibleMoves;
        }
    }

    public List<String> downRightMove(Board board, Player player, int startX, int startY) throws Exception {
        List<String> possibleMoves = new ArrayList<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder previousMove = new StringBuilder();
        if (startX == 7 || startY == 0) {
            return possibleMoves;
        } else {
            for (int i = 1; i < 7 && startY - i >= 0; i++) {
                actualMove.setLength(0);
                if (i < 2) {
                    if (board.hasNoPiece(startX + i, startY - i)) {
                        possibleMoves.add(actualMove.append(startX + i).append( startY - i).toString());
                    }
                } else {
                    if (possibleMoves.contains(previousMove.toString()) && board.hasNoPiece(startX + i, startY - i)) {
                        possibleMoves.add(actualMove.append(startX + i).append( startY - i).toString());
                    }
                }
                previousMove.setLength(0);
                previousMove.append(actualMove);
            }
            return possibleMoves;
        }
    }

    public List<String> downLeftMove(Board board, Player player, int startX, int startY) throws Exception {
        List<String> possibleMoves = new ArrayList<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder previousMove = new StringBuilder();
        if (startX == 0 || startY == 0) {
            return possibleMoves;
        } else {
            for (int i = 1; i < 7 && startY - i >= 0; i++) {
                actualMove.setLength(0);
                if (i < 2) {
                    if (board.hasNoPiece(startX - i, startY - i)) {
                        possibleMoves.add(actualMove.append(startX - i).append( startY - i).toString());
                    }
                } else {
                    if (possibleMoves.contains(previousMove.toString()) && board.hasNoPiece(startX - i, startY - i)) {
                        possibleMoves.add(actualMove.append(startX - i).append( startY - i).toString());
                    }
                }
                previousMove.setLength(0);
                previousMove.append(actualMove);
            }
            return possibleMoves;
        }
    }
}
