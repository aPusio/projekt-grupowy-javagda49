package com.sda.games.checkers.model.piece;

import com.sda.games.checkers.model.board.Board;
import com.sda.games.checkers.model.board.SpotFactory;
import com.sda.games.checkers.model.player.Player;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class RegularPiece extends Piece {
    private final boolean REGULAR = true;

    public RegularPiece(boolean white) {
        super(white);
    }

    @Override
    public boolean isRegular() {
        return REGULAR;
    }

    @Override
    public String getPieceIcon() {
        if (white) {
            return "\u25CF";
        } else {
            return "\u2B58";
        }
    }

    @Override
    public boolean hasMove(Board board, Player player, int startX, int startY) throws Exception {
        if (player.isWhite()) {
            if (startY == 7) {
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
            if (startY == 0) {
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

    @Override
    public boolean hasKill(Board board, Player player, int startX, int startY) throws Exception {
        if (validateExceptionsKilling(board, player, startX, startY)) {
            return true;
        } else if (validateCenterKilling(board, player, startX, startY)) {
            return true;
        } else if (validateLeftSideKilling(board, player, startX, startY)) {
            return true;
        } else if (validateRightSideKilling(board, player, startX, startY)) {
            return true;
        } else if (validateTopKilling(board, player, startX, startY)) {
            return true;
        } else return validateBottomKilling(board, player, startX, startY);
    }

    @Override
    public boolean upLeftKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        if (board.hasNoPiece(startX - 2, startY + 2)) {
            if (isPlayerWhite) {
                return board.pieceIsBlack(startX - 1, startY + 1);
            } else {
                return board.pieceIsWhite(startX - 1, startY + 1);
            }
        }
        return false;
    }

    @Override
    public boolean upRightKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        if (board.hasNoPiece(startX + 2, startY + 2)) {
            if (isPlayerWhite) {
                return board.pieceIsBlack(startX + 1, startY + 1);
            } else {
                return board.pieceIsWhite(startX + 1, startY + 1);
            }
        }
        return false;
    }

    @Override
    public boolean downLeftKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        if (board.hasNoPiece(startX - 2, startY - 2)) {
            if (isPlayerWhite) {
                return board.pieceIsBlack(startX - 1, startY - 1);
            } else {
                return board.pieceIsWhite(startX - 1, startY - 1);
            }
        }
        return false;
    }

    @Override
    public boolean downRightKill(Board board, boolean isPlayerWhite, int startX, int startY) throws Exception {
        if (board.hasNoPiece(startX + 2, startY - 2)) {
            if (isPlayerWhite) {
                return board.pieceIsBlack(startX + 1, startY - 1);
            } else {
                return board.pieceIsWhite(startX + 1, startY - 1);
            }
        }
        return false;
    }

    @Override
    public boolean validateExceptionsKilling(Board board, Player player, int startX, int startY) throws Exception {

        if ((startX == 0 && startY == 0) || (startX == 1 && startY == 1)) {
            return (upRightKill(board, player.isWhite(), startX, startY));
        } else if ((startX == 6 && startY == 0) || (startX == 7 && startY == 1)) {
            return (upLeftKill(board, player.isWhite(), startX, startY));
        } else if ((startX == 0 && startY == 6) || (startX == 1 && startY == 7)) {
            return (downRightKill(board, player.isWhite(), startX, startY));
        } else if ((startX == 6 && startY == 6) || (startX == 7 && startY == 7)) {
            return (downLeftKill(board, player.isWhite(), startX, startY));
        }
        return false;
    }

    @Override
    public boolean validateCenterKilling(Board board, Player player, int startX, int startY) throws Exception {
        if (startX > 1 && startY > 1 && startX < 6 && startY < 6) {
            if (upLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else if (upRightKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else if (downLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else {
                return (downRightKill(board, player.isWhite(), startX, startY));
            }
        }
        return false;
    }

    @Override
    public boolean validateLeftSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startX == 0 && (startY == 2 || startY == 4)) || (startX == 1 && (startY == 3 || startY == 5))) {
            if (upRightKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else {
                return (downRightKill(board, player.isWhite(), startX, startY));
            }
        }
        return false;
    }

    @Override
    public boolean validateRightSideKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startX == 7 && (startY == 3 || startY == 5)) || (startX == 6 && (startY == 2 || startY == 4))) {
            if (upLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else {
                return (downLeftKill(board, player.isWhite(), startX, startY));
            }
        }
        return false;
    }

    @Override
    public boolean validateTopKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startY == 7 && (startX == 3 || startX == 5))
                || (startY == 6 && (startX == 2 || startX == 4))) {
            if (downLeftKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else {
                return (downRightKill(board, player.isWhite(), startX, startY));
            }
        }
        return false;
    }

    @Override
    public boolean validateBottomKilling(Board board, Player player, int startX, int startY) throws Exception {
        if ((startY == 0 && (startX == 2 || startX == 4)) || (startY == 1 && (startX == 3 || startX == 5))) {
            if (upRightKill(board, player.isWhite(), startX, startY)) {
                return true;
            } else {
                return (upLeftKill(board, player.isWhite(), startX, startY));
            }
        }
        return false;
    }

    @Override
    public boolean killEnemyPiece(Board board, Player player, int startX, int startY, int endX, int endY) throws
            Exception {
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

}
