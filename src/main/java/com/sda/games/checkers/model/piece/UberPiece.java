package com.sda.games.checkers.model.piece;

import com.sda.games.checkers.model.board.Board;
import com.sda.games.checkers.model.player.Player;
import lombok.*;

import java.util.*;

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
        } else {
            if (board.pieceIsWhite(startX, startY)) {
                System.out.println("Not your piece!");
                return false;
            } else {
                return !possiblePrimaryMoves(board, player, startX, startY).isEmpty();
            }
        }
    }

    public List<String> possiblePrimaryMoves(Board board, Player player, int startX, int startY) throws Exception {
        List<String> allPossibleMoves = new ArrayList<>();
        allPossibleMoves.addAll(upRightMoves(board, startX, startY));
        allPossibleMoves.addAll(upLeftMoves(board, startX, startY));
        allPossibleMoves.addAll(downRightMoves(board, startX, startY));
        allPossibleMoves.addAll(downLeftMoves(board, startX, startY));
        allPossibleMoves.forEach(System.out::println);
        return allPossibleMoves;
    }

    public List<String> upRightMoves(Board board, int startX, int startY) throws Exception {
        List<String> possibleMoves = new ArrayList<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder previousMove = new StringBuilder();
        if (startX != 7 && startY != 7) {
            for (int i = 1; i < 7 && startX + i <= 7 && startY + i <= 7; i++) {
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
        }
        return possibleMoves;
    }

    public List<String> upLeftMoves(Board board, int startX, int startY) throws Exception {
        List<String> possibleMoves = new ArrayList<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder previousMove = new StringBuilder();
        if (startX != 0 && startY != 7) {
            for (int i = 1; i < 7 && startX - i >= 0 && startY + i <= 7; i++) {
                actualMove.setLength(0);
                if (i < 2) {
                    if (board.hasNoPiece(startX - i, startY + i)) {
                        possibleMoves.add(actualMove.append(startX - i).append(startY + i).toString());
                    }
                } else {
                    if (possibleMoves.contains(previousMove.toString()) && board.hasNoPiece(startX - i, startY + i)) {
                        possibleMoves.add(actualMove.append(startX - i).append(startY + i).toString());
                    }
                }
                previousMove.setLength(0);
                previousMove.append(actualMove);
            }
        }
        return possibleMoves;
    }

    public List<String> downRightMoves(Board board, int startX, int startY) throws Exception {
        List<String> possibleMoves = new ArrayList<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder previousMove = new StringBuilder();
        if (startX != 7 && startY != 0) {
            for (int i = 1; i < 7 && startX + i <= 7 && startY - i >= 0; i++) {
                actualMove.setLength(0);
                if (i < 2) {
                    if (board.hasNoPiece(startX + i, startY - i)) {
                        possibleMoves.add(actualMove.append(startX + i).append(startY - i).toString());
                    }
                } else {
                    if (possibleMoves.contains(previousMove.toString()) && board.hasNoPiece(startX + i, startY - i)) {
                        possibleMoves.add(actualMove.append(startX + i).append(startY - i).toString());
                    }
                }
                previousMove.setLength(0);
                previousMove.append(actualMove);
            }
        }
        return possibleMoves;
    }

    public List<String> downLeftMoves(Board board, int startX, int startY) throws Exception {
        List<String> possibleMoves = new ArrayList<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder previousMove = new StringBuilder();
        if (startX != 0 && startY != 0) {
            for (int i = 1; i < 7 && startX - i >= 0 && startY - i >= 0; i++) {
                actualMove.setLength(0);
                if (i < 2) {
                    if (board.hasNoPiece(startX - i, startY - i)) {
                        possibleMoves.add(actualMove.append(startX - i).append(startY - i).toString());
                    }
                } else {
                    if (possibleMoves.contains(previousMove.toString()) && board.hasNoPiece(startX - i, startY - i)) {
                        possibleMoves.add(actualMove.append(startX - i).append(startY - i).toString());
                    }
                }
                previousMove.setLength(0);
                previousMove.append(actualMove);
            }
        }
        return possibleMoves;
    }

    @Override
    public boolean hasKill(Board board, Player player, int startX, int startY) throws Exception {
        return !possibleKills(board, player, startX, startY).isEmpty();
    }

    @Override
    public boolean killEnemyPiece(Board board, Player player, int startX, int startY, int endX, int endY) throws Exception {
        String killed = possibleKills(board, player, startX, startY).get(String.valueOf(endX) + endY);
        if (killed == null) {
            return false;
        } else {
            board.setBoardPieceNull(Integer.parseInt(String.valueOf(killed.charAt(0))),
                    Integer.parseInt(String.valueOf(killed.charAt(1))));
            return true;
        }
    }

    public Map<String, String> possibleKills(Board board, Player player, int startX, int startY) throws Exception {
        Map<String, String> allPossibleKills = new HashMap<>();
        allPossibleKills.putAll(upRightKill(board, player, startX, startY));
        allPossibleKills.putAll(upLeftKill(board, player, startX, startY));
        allPossibleKills.putAll(downRightKill(board, player, startX, startY));
        allPossibleKills.putAll(downLeftKill(board, player, startX, startY));
        allPossibleKills.forEach((key, value) -> System.out.println(key + ":" + value));
        return allPossibleKills;
    }

    public Map<String, String> upRightKill(Board board, Player player, int startX, int startY) throws Exception {
        Map<String, String> possibleKill = new HashMap<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder killedPiece = new StringBuilder();
        if (startX == 6 || startY == 6) {
            return possibleKill;
        } else {
            if (player.isWhite()) {
                for (int i = 1; i < 6 && startX + i <= 6 && startY + i <= 6; i++) {
                    if (board.hasNoPiece(startX + i, startY + i)) {
                        continue;
                    } else if (board.hasPiece(startX + i, startY + i) && !board.getPiece(startX + i, startY + i).isWhite()) {
                        if (board.hasNoPiece(startX + i + 1, startY + i + 1)) {
                            possibleKill.put(actualMove.append(startX + i + 1).append(startY + i + 1).toString(),
                                    killedPiece.append(startX + i).append(startY + i).toString());
                            return possibleKill;
                        }
                    } else {
                        return possibleKill;
                    }
                }
            } else {
                for (int i = 1; i < 6 && startX + i <= 6 && startY + i <= 6; i++) {
                    if (board.hasNoPiece(startX + i, startY + i)) {
                        continue;
                    } else if (board.hasPiece(startX + i, startY + i) && board.getPiece(startX + i, startY + i).isWhite()
                            && board.hasNoPiece(startX + i + 1, startY + i + 1)) {
                        possibleKill.put(actualMove.append(startX + i + 1).append(startY + i + 1).toString(),
                                killedPiece.append(startX + i).append(startY + i).toString());
                        return possibleKill;

                    } else {
                        return possibleKill;
                    }
                }
            }
        }
        return possibleKill;
    }

    public Map<String, String> upLeftKill(Board board, Player player, int startX, int startY) throws Exception {
        Map<String, String> possibleKill = new HashMap<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder killedPiece = new StringBuilder();
        if (startX == 1 || startY == 6) {
            return possibleKill;
        } else {
            if (player.isWhite()) {
                for (int i = 1; i < 6 && startX - i >= 1 && startY + i <= 6; i++) {
                    if (board.hasNoPiece(startX - i, startY + i)) {
                        continue;
                    } else if (board.hasPiece(startX - i, startY + i) && !board.getPiece(startX - i, startY + i).isWhite()
                            && board.hasNoPiece(startX - i - 1, startY + i + 1)) {
                        possibleKill.put(actualMove.append(startX - i - 1).append(startY + i + 1).toString(),
                                killedPiece.append(startX - i).append(startY + i).toString());
                        return possibleKill;
                    } else {
                        return possibleKill;
                    }
                }
            } else {
                for (int i = 1; i < 6 && startX - i >= 1 && startY + i <= 6; i++) {
                    if (board.hasNoPiece(startX - i, startY + i)) {
                        continue;
                    } else if (board.hasPiece(startX - i, startY + i) && board.getPiece(startX - i, startY + i).isWhite()
                            && board.hasNoPiece(startX - i - 1, startY + i + 1)) {
                        possibleKill.put(actualMove.append(startX - i - 1).append(startY + i + 1).toString(),
                                killedPiece.append(startX - i).append(startY + i).toString());
                        return possibleKill;
                    } else {
                        return possibleKill;
                    }
                }
            }
        }
        return possibleKill;
    }

    public Map<String, String> downRightKill(Board board, Player player, int startX, int startY) throws Exception {
        Map<String, String> possibleKill = new HashMap<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder killedPiece = new StringBuilder();
        if (startX == 6 || startY == 1) {
            return possibleKill;
        } else {
            if (player.isWhite()) {
                for (int i = 1; i < 6 && startX + i <= 6 && startY - i >= 1; i++) {
                    if (board.hasNoPiece(startX + i, startY - i)) {
                        continue;
                    } else if (board.hasPiece(startX + i, startY - i) && !board.getPiece(startX + i, startY - i).isWhite()
                            && board.hasNoPiece(startX + i + 1, startY - i - 1)) {
                        possibleKill.put(actualMove.append(startX + i + 1).append(startY - i - 1).toString(),
                                killedPiece.append(startX + i).append(startY - i).toString());
                        return possibleKill;
                    } else {
                        return possibleKill;
                    }
                }
            } else {
                for (int i = 1; i < 6 && startX + i <= 6 && startY - i >= 1; i++) {
                    if (board.hasNoPiece(startX + i, startY - i)) {
                        continue;
                    } else if (board.hasPiece(startX + i, startY - i) && board.getPiece(startX + i, startY - i).isWhite()
                            && board.hasNoPiece(startX + i + 1, startY - i - 1)) {
                        possibleKill.put(actualMove.append(startX + i + 1).append(startY - i - 1).toString(),
                                killedPiece.append(startX + i).append(startY - i).toString());
                        return possibleKill;
                    } else {
                        return possibleKill;
                    }
                }
            }
        }
        return possibleKill;
    }

    public Map<String, String> downLeftKill(Board board, Player player, int startX, int startY) throws Exception {
        Map<String, String> possibleKill = new HashMap<>();
        StringBuilder actualMove = new StringBuilder();
        StringBuilder killedPiece = new StringBuilder();
        if (startX == 1 || startY == 1) {
            return possibleKill;
        } else {
            if (player.isWhite()) {
                for (int i = 1; i < 6 && startX - i >= 1 && startY - i >= 1; i++) {
                    if (board.hasNoPiece(startX - i, startY - i)) {
                        continue;
                    } else if (board.hasPiece(startX - i, startY - i) && !board.getPiece(startX - i, startY - i).isWhite()
                            && board.hasNoPiece(startX - i - 1, startY - i - 1)) {
                        possibleKill.put(actualMove.append(startX - i - 1).append(startY - i - 1).toString(),
                                killedPiece.append(startX - i).append(startY - i).toString());
                        return possibleKill;
                    } else {
                        return possibleKill;
                    }
                }
            } else {
                for (int i = 1; i < 6 && startX - i >= 1 && startY - i >= 1; i++) {
                    if (board.hasNoPiece(startX - i, startY - i)) {
                        continue;
                    } else if (board.hasPiece(startX - i, startY - i) && board.getPiece(startX - i, startY - i).isWhite()
                            && board.hasNoPiece(startX - i - 1, startY - i - 1)) {
                        possibleKill.put(actualMove.append(startX - i - 1).append(startY - i - 1).toString(),
                                killedPiece.append(startX - i).append(startY - i).toString());
                        return possibleKill;
                    } else {
                        return possibleKill;
                    }
                }
            }
        }
        return possibleKill;
    }
}
