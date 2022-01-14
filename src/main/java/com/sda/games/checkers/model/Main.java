package com.sda.games.checkers.model;

import com.sda.games.checkers.model.game.Game;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Game game = new Game();
        game.runGame();

    }
}
