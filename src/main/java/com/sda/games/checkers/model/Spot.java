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

    public boolean isEndSpotValid(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        if (player.isWhite() && (startY - endY) != -1) {
            System.out.println("Invalid move!");
        } else if (!player.isWhite() && (startY - endY != 1)) {
            System.out.println("Invalid move!");
        } else if (startX - endX != -1 && startX - endX != 1) {
            System.out.println("Invalid move!");
        } else if (board.getBoardSpot(endX, endY).getPiece() != null) {
            System.out.println("Invalid move! (Piece on destination)");
        } else {
            return true;
        }
        return false;
    }
}
