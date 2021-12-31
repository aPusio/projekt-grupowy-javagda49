package com.sda.games.checkers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    private List<Player> players;
    private Board board;
    private Player currentTurnPlayer;
    private GameStatus status;
    private List<Move> movesPlayed;
    private Scanner scanner = new Scanner(System.in);

    public void newGame() {
        System.out.println("Enter White Player name:");
        Player whitePlayer = new Player(1, Player.whitePlayerName = scanner.nextLine(), true);
        System.out.println("Enter Black Player name:");
        Player blackPlayer = new Player(2, Player.blackPlayerName = scanner.nextLine(), false);


        initialize(whitePlayer, blackPlayer);
        getBoard().printBoard();
    }

    public void initialize(Player player1, Player player2) {
        this.players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        this.board = new Board();
        board.resetBoard();

        if (player1.isWhite()) {
            this.currentTurnPlayer = player1;
        } else {
            this.currentTurnPlayer = player2;
        }

        this.movesPlayed = new ArrayList<>();
        movesPlayed.clear();
    }

    public boolean makeMove() throws Exception {

        System.out.println(getCurrentTurnPlayer().getName() + " move.");


        int startX;
        int startY;

        while(true) {

            System.out.println("Which checker to move?");
            String startSpotXY = scanner.nextLine();
            int flagStartX = startSpotXY.charAt(0);
            int flagStartY = startSpotXY.charAt(1);
            startX = flagStartX - 97;
            startY = flagStartY - 49;

            Piece sourcePiece = board.getBoardSpot(startY, startX).getPiece();

            if (getCurrentTurnPlayer().isWhite() != sourcePiece.isWhite()) {
                System.out.println("Not your piece!");
            } else {
                break;
            }
        }

        int endX;
        int endY;

        while (true) {

            System.out.println("Where to go?");
            String endSpotXY = scanner.nextLine();
            int flagEndX = endSpotXY.charAt(0);
            int flagEndY = endSpotXY.charAt(1);
            endX = flagEndX - 97;
            endY = flagEndY - 49;

            if (currentTurnPlayer.isWhite() && (startY - endY) != -1) {
                System.out.println("Invalid move! (Can't move back)");
            } else if (!currentTurnPlayer.isWhite() && (startY - endY != 1)) {
                System.out.println("Invalid move! (Can't move back)");
            } else if (board.getBoardSpot(endY, endX).getPiece() != null) {
                System.out.println("Invalid move! (Piece on destination)");
            } else {
                break;
            }
        }

        Player currentPlayer = getCurrentTurnPlayer();

        Spot startSpot = getBoard().getBoardSpot(startX, startY);
        Spot endSpot = getBoard().getBoardSpot(endX, endY);

        Move move = new Move(currentPlayer, startSpot, endSpot, startSpot.getPiece());

        move.getEnd().setPiece(move.getStart().getPiece());

        board.setBoardSpot(startX, startY, endX, endY);

        if (this.currentTurnPlayer == players.get(0)) {
            this.currentTurnPlayer = players.get(1);
        } else {
            this.currentTurnPlayer = players.get(0);
        }


        movesPlayed.add(move);


        getBoard().printBoard();

        return true;
    }

    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }

}
