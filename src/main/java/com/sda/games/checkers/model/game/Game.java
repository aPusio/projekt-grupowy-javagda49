package com.sda.games.checkers.model.game;

import com.sda.games.checkers.model.board.Board;
import com.sda.games.checkers.model.board.Spot;
import com.sda.games.checkers.model.piece.Piece;
import com.sda.games.checkers.model.player.Move;
import com.sda.games.checkers.model.player.Player;
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
    private Player currentPlayer;
    private GameStatus status;
    private List<Move> movesPlayed;
    private static Scanner scanner = new Scanner(System.in);
    private Object game;

    public void runGame() throws Exception {
        Menu.mainMenu();
    }

    public List<Player> createPlayers() {
        System.out.println("Enter White Player name:");
        Player whitePlayer = new Player(1, Player.whitePlayerName = scanner.nextLine(), true, 0);
        System.out.println("Enter Black Player name:");
        Player blackPlayer = new Player(2, Player.blackPlayerName = scanner.nextLine(), false, 0);

        players = new ArrayList<>();
        players.add(whitePlayer);
        players.add(blackPlayer);

        return players;
    }

    public Game newGame() {
        players = createPlayers();

        Game game = initialize(players);
        getBoard().printBoard();
        return game;
    }

    public void continueGame() {

    }

    public Game initialize(List<Player> players) {

        board = new Board();
        board.resetBoard();

        Player player1 = players.get(0);
        Player player2 = players.get(1);

        if (player1.isWhite()) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }

        movesPlayed = new ArrayList<>();
        return (Game) this.game;
    }

    public String getStringXY() throws Exception {
        Pattern movePattern = Pattern.compile("[a-hA-H][1-8]");
        String spotXY;
        while (true) {
            do {
                spotXY = scanner.nextLine();
                if (spotXY.equals("exit")) {
                    Menu.mainMenu();
                    break;
                } else if (spotXY.length() != 2) {
                    System.out.println("Invalid input!");
                }
            } while (spotXY.length() != 2);
            Matcher matcher = movePattern.matcher(spotXY);
            boolean isInputValid = matcher.matches();
            if (isInputValid) {
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }
        char charX = spotXY.charAt(0);
        char charY = spotXY.charAt(1);

        return String.valueOf(charX - 97) + charY;
    }

    public void makeMove() throws Exception {

        System.out.println(currentPlayer.getName() + " move.");

        String startSpotXY;
        String endSpotXY;
        int startX;
        int startY;
        int endX;
        int endY;

        // Choosing checker to move
        do {
            System.out.println("Which checker to move?");
            startSpotXY = getStringXY();
            startX = Integer.parseInt(String.valueOf(startSpotXY.charAt(0)));
            startY = Integer.parseInt(String.valueOf(startSpotXY.charAt(1))) - 1;

            if (board.isEmpty(startX, startY)) {
                System.out.println("No checker here!");
            }
        } while (!board.getBoardSpot(startX, startY).isStartSpotValid(board, currentPlayer, board.getPiece(startX, startY), startX, startY));
        // Choosing where to move
        do {
            System.out.println("Where to go?");
            endSpotXY = getStringXY();
            endX = Integer.parseInt(String.valueOf(endSpotXY.charAt(0)));
            endY = Integer.parseInt(String.valueOf(endSpotXY.charAt(1))) - 1;

            if (board.isEmpty(endX, endY)) {
                System.out.println("Invalid board spot!");
            } else if (board.getBoardSpot(endX, endY).isEndSpotValid(board, currentPlayer, startX, startY, endX, endY)) {
                board.setSpotsAfterMove(startX, startY, endX, endY);
                board.advancePiece(endX, endY, currentPlayer);
                getBoard().printBoard();
                break;
            } else if (board.getPiece(startX, startY).hasKill(board, currentPlayer, startX, startY)) {
                if (board.getPiece(startX, startY).killEnemyPiece(board, currentPlayer, startX, startY, endX, endY)) {
                    currentPlayer.killCounter();
                    board.setSpotsAfterMove(startX, startY, endX, endY);
                    board.advancePiece(endX, endY, currentPlayer);
                    getBoard().printBoard();
                    startX = endX;
                    startY = endY;
                } else {
                    System.out.println("Invalid move!");
                }
            }
        } while (board.getPiece(startX, startY).hasKill(board, currentPlayer, startX, startY));
//        board.advancePiece(endX, endY, currentPlayer);
        currentPlayer = currentPlayer.switchPlayers(currentPlayer, players);
    }

    public boolean isActive() {
        return (currentPlayer.kills != 12);
    }
}
