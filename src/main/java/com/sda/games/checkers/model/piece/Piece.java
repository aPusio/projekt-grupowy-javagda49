package com.sda.games.checkers.model.piece;

import com.sda.games.checkers.model.board.Board;
import com.sda.games.checkers.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Piece {

    public boolean white;
    private boolean regular;
    private boolean killed;
    private String pieceIcon;

    public String getPieceIcon() {
        return this.pieceIcon;
    }

    public Piece(boolean white) {
        this.white = white;
    }

    public abstract boolean isRegular();

    public boolean hasMove(Board board, Player player, int startX, int startY) throws Exception {
        return false;
    }

    public boolean hasKill(Board board, Player player, int startX, int startY) throws Exception {
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

}
