package com.sda.games.checkers.logic.piece;

import com.sda.games.checkers.logic.board.Board;
import com.sda.games.checkers.logic.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Piece {

    public boolean white;
    private boolean killed;
    private String pieceIcon;

    public String getPieceIcon() {
        return this.pieceIcon;
    }

    public Piece(boolean white) {
        this.white = white;
    }

    public abstract boolean isRegular();

    public abstract boolean hasMove(Board board, Player player, int startX, int startY) throws Exception;

    public boolean hasKill(Board board, Player player, int startX, int startY) throws Exception {
        return false;
    }

    public boolean upLeftMove(Board board, int startX, int startY) throws Exception {
        return  (board.hasNoPiece(startX - 1, startY + 1));
    }

    public boolean upRightMove(Board board, int startX, int startY) throws Exception {
        return (board.hasNoPiece(startX + 1, startY + 1));
    }

    public boolean downLeftMove(Board board, int startX, int startY) throws Exception {
        return (board.hasNoPiece(startX - 1, startY - 1));
    }

    public boolean downRightMove(Board board, int startX, int startY) throws Exception {
        return  (board.hasNoPiece(startX + 1, startY - 1));
    }

    public boolean validateExceptionsMoves(Board board, int startX, int startY) {
        return false;
    }
    public boolean validateCenterMoves(Board board, int startX, int startY) {
        return false;
    }
    public boolean validateLeftMoves(Board board, int startX, int startY) {
        return false;
    }
    public boolean validateRightMoves(Board board, int startX, int startY) {
        return false;
    }
    public boolean validateTopMoves(Board board, int startX, int startY) {
        return false;
    }
    public boolean validateBottomMoves(Board board, int startX, int startY) {
        return false;
    }

    public boolean upLeftKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        return false;
    }

    public boolean upRightKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        return false;
    }

    public boolean downLeftKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        return false;
    }

    public boolean downRightKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        return false;
    }

    public boolean validateExceptionsKilling(Board board, Player player, int startX, int startY) throws Exception {
        return false;
    }

    public boolean validateCenterKilling(Board board, Player player, int startX, int startY) throws Exception {
        return false;
    }

    public boolean validateLeftSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        return false;
    }

    public boolean validateRightSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        return false;
    }

    public boolean validateTopKilling(Board board, Player player, int startX, int startY) throws Exception {
        return false;
    }

    public boolean validateBottomKilling(Board board, Player player, int startX, int startY) throws Exception {
        return false;
    }

    public boolean killEnemyPiece(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        return false;
    }

    public abstract List<String> possiblePrimaryMoves(Board board, Player player, int startX, int startY) throws Exception;

}
