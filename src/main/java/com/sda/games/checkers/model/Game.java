package com.sda.games.checkers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    static String whitePlayerName;
    static String blackPlayerName;

    private Player[] players;
    private Board board;
    private Player currentTurnPlayer;
    private GameStatus status;
    private List<Move> movesPlayed;
    private Scanner scanner = new Scanner(System.in);

    public Game() {
        this.players = new Player[2];
        this.board = new Board();
        this.currentTurnPlayer = currentTurnPlayer;
        this.status = status;
        this.movesPlayed = new ArrayList<>();
    }

    public void newGame() {
        System.out.println("Enter White Player name:");
        this.whitePlayerName = scanner.nextLine();
        System.out.println("Enter Black Player name:");
        this.blackPlayerName = scanner.nextLine();

        Player whitePlayer = new Player(1, whitePlayerName, true);
        Player blackPlayer = new Player(2, blackPlayerName, false);

        initialize(whitePlayer, blackPlayer);
        getBoard().printBoard();
    }

    public void initialize(Player player1, Player player2) {
        this.players[0] = player1;
        this.players[1] = player2;

        board.resetBoard();

        if (player1.isWhite()) {
            this.currentTurnPlayer = player1;
        } else {
            this.currentTurnPlayer = player2;
        }

        movesPlayed.clear();
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
        Spot startSpot = board.getBoardSpot(startX, startY);
        Spot endSpot = board.getBoardSpot(endX, endY);
        Move move = new Move(player, startSpot, endSpot);
        return this.makeMove(move, player);
    }

    public boolean makeMove(Move move, Player player) {



        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) {
            return false;
        }

        if (player != currentTurnPlayer) {
            return false;
        }

        if (sourcePiece.isWhite() != player.isWhite()) {
            return false;
        }

        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            return false;
        }

        movesPlayed.add(move);

        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

//        if (this.currentTurnPlayer == players[0]) {
//            this.currentTurnPlayer = players[1];
//        } else {
//            this.currentTurnPlayer = players[0];
//        }

        return true;
    }

    public void getNextMove() throws Exception {
        System.out.println(getCurrentTurnPlayer().getName() + " move.");

        System.out.println(players[0].getName());
        System.out.println(players[1].getName());

        System.out.println("Which checker to move?");
        String startSpotXY = scanner.nextLine();
        System.out.println("Where to go?");
        String endSpotXY = scanner.nextLine();

        int flagStartX = startSpotXY.charAt(0);
        int flagStartY = startSpotXY.charAt(1);

        int startX = flagStartX - 97;
        int startY = flagStartY - 49;

        System.out.println("Start spot: [" + startX + "][" + startY + "]");

        int flagEndX = endSpotXY.charAt(0);
        int flagEndY = endSpotXY.charAt(1);

        int endX = flagEndX - 97;
        int endY = flagEndY - 49;

        System.out.println("End spot: [" + endX + "][" + endY + "]");

        playerMove(getCurrentTurnPlayer(), startX, startY, endX, endY);
        Player currentPlayer = getCurrentTurnPlayer();

        Spot startSpot = getBoard().getBoardSpot(startX, startY);
        Spot endSpot = getBoard().getBoardSpot(endX, endY);

        Move move = new Move(currentPlayer, startSpot, endSpot);
        makeMove(move, currentPlayer);

        if (this.currentTurnPlayer == players[0]) {
            this.currentTurnPlayer = players[1];
        } else {
            this.currentTurnPlayer = players[0];
        }

        getBoard().printBoard();
    }

    public static String getWhitePlayerName() {
        return whitePlayerName;
    }

    public static String getBlackPlayerName() {
        return blackPlayerName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentTurnPlayer() {
        return currentTurnPlayer;
    }

    public List<Move> getMovesPlayed() {
        return movesPlayed;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }

}
