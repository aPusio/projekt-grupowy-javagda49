package com.sda.games.checkers.model.piece;

import com.sda.games.checkers.model.board.Board;
import com.sda.games.checkers.model.player.Player;
import lombok.*;

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

    public Map<Integer,Integer> upLeftMove(Board board, Player player, int startX, int startY) throws Exception {
        Map<Integer,Integer> possibleMoves = new HashMap<>();
        if(startY == 7 || startX == 7){
            return possibleMoves;
        } else {
            for (int i = 1; i < 7; i++) {
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
        }
        return possibleMoves;
    }
}
