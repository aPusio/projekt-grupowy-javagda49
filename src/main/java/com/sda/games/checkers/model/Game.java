package com.sda.games.checkers.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Player currentPlayer = getCurrentTurnPlayer();

        System.out.println(getCurrentTurnPlayer().getName() + " move.");

        Pattern movePattern = Pattern.compile("[a-hA-H][1-8]");

        String startSpotXY = "";
        char charStartY;
        char charStartX;
        int startX;
        int startY;
        String endSpotXY = "";
        char charEndX;
        char charEndY;
        int endX;
        int endY;
        Piece sourcePiece;

        // Choosing checker to move
        while (true) {
            while (true) {
                System.out.println("Which checker to move?");
                startSpotXY = scanner.nextLine();

                Matcher matcher = movePattern.matcher(startSpotXY);
                boolean isInputValid = matcher.matches();

                charStartX = startSpotXY.charAt(0);
                charStartY = startSpotXY.charAt(1);
                startX = charStartX - 97;
                startY = charStartY - 49;

                // Start piece validation
                if (!isInputValid) {
                    System.out.println("Invalid input!");
                } else {
                    if (board.getBoardSpot(startX, startY) == null) {
                        System.out.println("No checker here!");
                    } else {
                        sourcePiece = board.getBoardSpot(startX, startY).getPiece();
                        if (sourcePiece.isStartPieceValid(board, currentTurnPlayer, startX, startY)) {
                            break;
                        }
                    }
                }
            }
            break;
        }
        // Choosing where to move
        while (true) {
            while (true) {
                System.out.println("Where to go?");
                endSpotXY = scanner.nextLine();

                Matcher matcher = movePattern.matcher(endSpotXY);
                boolean isInputValid = matcher.matches();

                charEndX = endSpotXY.charAt(0);
                charEndY = endSpotXY.charAt(1);
                endX = charEndX - 97;
                endY = charEndY - 49;

                // End spot validation
                if (!isInputValid) {
                    System.out.println("Invalid input!");
                } else {
                    if (board.getBoardSpot(endX, endY) == null) {
                        System.out.println("Invalid board spot!");
                    } else if (board.getBoardSpot(endX, endY).isEndSpotValid(board, currentTurnPlayer, startX, startY, endX, endY)) {
                        break;
                    }
                }
            }
                break;
        }

        Spot startSpot = getBoard().getBoardSpot(startX, startY);
        Spot endSpot = getBoard().getBoardSpot(endX, endY);

        Move move = new Move(currentPlayer, startSpot, endSpot, startSpot.getPiece());

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
