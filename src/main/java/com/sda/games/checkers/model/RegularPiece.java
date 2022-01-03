package com.sda.games.checkers.model;

import javax.sound.midi.Soundbank;

public class RegularPiece extends Piece{

    public RegularPiece(boolean white) {
        super(white);
    }

    @Override
    public boolean isStartPieceValid(Board board, Player player, int startX, int startY) throws Exception {
            if (player.isWhite()) {
                if (!board.getBoardSpot(startX, startY).getPiece().isWhite()) {
                    System.out.println("Not your piece!");
                } else if (startX == 0 && (board.getBoardSpot(startX + 1, startY + 1).getPiece() != null)) {
                    System.out.println("No move available!");
                } else if (startX == 7 && (board.getBoardSpot(startX - 1, startY + 1).getPiece() != null)) {
                    System.out.println("No move available!");
                } else if (board.getBoardSpot(startX + 1, startY + 1).getPiece() != null &&
                        board.getBoardSpot(startX - 1, startY + 1).getPiece() != null) {
                    System.out.println("No move available!");
                } else {
                    return true;
                }
            } else if (!player.isWhite()) {
                if (board.getBoardSpot(startX, startY).getPiece().isWhite()) {
                    System.out.println("Not your piece!");
                } else if (startX == 0 && (board.getBoardSpot(startX + 1, startY - 1).getPiece() != null)) {
                    System.out.println("No move available!");
                } else if (startX == 7 && (board.getBoardSpot(startX - 1, startY - 1).getPiece() != null)) {
                    System.out.println("No move available!");
                } else if (board.getBoardSpot(startX + 1, startY - 1).getPiece() != null &&
                        board.getBoardSpot(startX - 1, startY - 1).getPiece() != null) {
                    System.out.println("No move available!");
                } else {
                    return true;
                }
            }
            return false;
    }

//    @Override
//    public boolean isEndSpotValid(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
//        if (player.isWhite() && (startY - endY) != -1) {
//            System.out.println("Invalid move!");
//        } else if (!player.isWhite() && (startY - endY != 1)) {
//            System.out.println("Invalid move!");
//        } else if (startX - endX != -1 && startX - endX != 1) {
//            System.out.println("Invalid move!");
//        } else if (board.getBoardSpot(endX, endY).getPiece() != null) {
//            System.out.println("Invalid move! (Piece on destination)");
//        } else {
//            return true;
//        }
//        return false;
//    }
}
