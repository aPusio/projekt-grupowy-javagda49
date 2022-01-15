package com.sda.games.checkers.logic.game;

import com.sda.games.checkers.database.dao.MoveDao;
import com.sda.games.checkers.database.model.MoveEntity;
import com.sda.games.checkers.database.model.PlayerEntity;
import com.sda.games.checkers.logic.board.Board;
import com.sda.games.checkers.logic.board.Spot;
import com.sda.games.checkers.database.dao.PlayerDao;
import com.sda.games.checkers.logic.player.Move;
import com.sda.games.checkers.logic.player.Player;
import com.sda.utils.HibernateFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public void runGame() throws Exception {
        Menu.mainMenu();
    }

    public List<Player> createPlayers() {
        HibernateFactory hibernateFactory = new HibernateFactory();
        PlayerDao playerDao = new PlayerDao(hibernateFactory);
        players = new ArrayList<>();

        while (true) {
            System.out.println("Enter White Player name:");
            Player whitePlayer = new Player(Player.whitePlayerName = scanner.nextLine(), true, 0);
            if (playerDao.getByName(whitePlayer.getName()).isEmpty()) {
                players.add(whitePlayer);
                playerDao.add(new PlayerEntity(whitePlayer));
                break;
            } else {
                System.out.println("Player already in Data Base!");
            }
        }
        while (true) {
            System.out.println("Enter Black Player name:");
            Player blackPlayer = new Player(Player.blackPlayerName = scanner.nextLine(), false, 0);
            if (playerDao.getByName(blackPlayer.getName()).isEmpty()) {
                players.add(blackPlayer);
                playerDao.add(new PlayerEntity(blackPlayer));
                break;
            } else {
                System.out.println("Player already in Data Base!");
            }
        }

        playerDao.getAll().forEach(System.out::println);

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
        return this;
    }

    public String getPlayerInput() throws Exception {
        Pattern movePattern = Pattern.compile("[a-hA-H][1-8]");
        String input;
        while (true) {
            do {
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    Menu.mainMenu();
                    break;
                } else if (input.length() != 2) {
                    System.out.println("Invalid input!");
                }
            } while (input.length() != 2);
            Matcher matcher = movePattern.matcher(input);
            boolean isInputValid = matcher.matches();
            if (isInputValid) {
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }

        return input;
    }

    public String convertPlayerInput(String input) {
        char charX = input.charAt(0);
        char charY = input.charAt(1);
        return String.valueOf(charX - 97) + charY;
    }

    public void makeMove() throws Exception {
        HibernateFactory hibernateFactory = new HibernateFactory();
        MoveDao moveDao = new MoveDao(hibernateFactory);

        System.out.println(currentPlayer.getName() + " move.");

        String startInput;
        String endInput;
        String startSpotXY;
        String endSpotXY;
        int startX;
        int startY;
        int endX;
        int endY;

        // Choosing checker to move
        boolean isSpotValid;
        do {
            System.out.println("Which checker to move?");
            startInput = getPlayerInput();
            startSpotXY = convertPlayerInput(startInput);
            startX = Integer.parseInt(String.valueOf(startSpotXY.charAt(0)));
            startY = Integer.parseInt(String.valueOf(startSpotXY.charAt(1))) - 1;
            isSpotValid = Spot.validateStartSpot(board, currentPlayer, startX, startY);
        } while (!isSpotValid);

        // Choosing where to move
        while (true) {
            System.out.println("Where to go?");
            endInput = getPlayerInput();
            endSpotXY = convertPlayerInput(endInput);
            endX = Integer.parseInt(String.valueOf(endSpotXY.charAt(0)));
            endY = Integer.parseInt(String.valueOf(endSpotXY.charAt(1))) - 1;

            if (board.isEmpty(endX, endY)) {
                System.out.println("Invalid board spot!");
            } else if (board.getBoardSpot(endX, endY).isEndSpotValid(board, currentPlayer, startX, startY, endX, endY)) {
                moveDao.add(new MoveEntity(0,startInput, endInput, currentPlayer.isWhite()));
                board.setSpotsAfterMove(startX, startY, endX, endY);
                board.advancePiece(endX, endY, currentPlayer);
                getBoard().printBoard();
                break;
            } else if (board.getPiece(startX, startY).hasKill(board, currentPlayer, startX, startY)) {
                if (board.getPiece(startX, startY).killEnemyPiece(board, currentPlayer, startX, startY, endX, endY)) {
                    currentPlayer.killCounter();
                    moveDao.add(new MoveEntity(0,startInput, endInput, currentPlayer.isWhite()));
                    board.setSpotsAfterMove(startX, startY, endX, endY);
                    board.advancePiece(endX, endY, currentPlayer);
                    getBoard().printBoard();
                    startX = endX;
                    startY = endY;
                    if (board.getPiece(startX, startY).hasKill(board, currentPlayer, startX, startY)) {
                        System.out.println("Another kill!");
                    } else {
                        break;
                    }
                }
            }
        }
        currentPlayer = currentPlayer.switchPlayers(currentPlayer, players);
    }

    public boolean isActive() {
        return (currentPlayer.kills != 12);
    }
}
