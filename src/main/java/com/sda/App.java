package com.sda;

import com.sda.games.checkers.logic.game.Game;
import com.sda.games.kamiennozycepapier.game.RockPaperScissorsBuilder;
import com.sda.utils.MainMenu;
import com.sda.utils.UserIoService;

public class App
{
    public static void main( String[] args ) throws Exception {
        UserIoService userIoService = new UserIoService();
        MainMenu mainMenu = new MainMenu();
        while (true) {
        userIoService.printOnScreen(mainMenu.createMenu());
            String userOption = String.valueOf(userIoService.getInt("Wpisz numer gry:"));
            switch (userOption) {
                case "1":
                    RockPaperScissorsBuilder.build().start();
                    break;
                case "2":
                    System.out.println("Implement me 🤣🤣");
                    break;
                case "3":
                    System.out.println("Implement me 🤣🤣");
                    break;
                case "4":
                    Game game = new Game();
                    game.runGame();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Option Not recognized");
            }
        }
    }
}
