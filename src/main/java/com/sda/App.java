package com.sda;

import com.sda.games.kamiennozycepapier.game.RockPaperScissorsBuilder;
import com.sda.utils.MainMenu;
import com.sda.utils.UserIoService;
import lombok.SneakyThrows;

public class App {

    @SneakyThrows
    public static void main(String[] args) {
        UserIoService userIoService = new UserIoService();
        MainMenu mainMenu = new MainMenu();
        userIoService.printOnScreen(mainMenu.createMenu());
        Integer userOption = userIoService.getInt("Wpisz numer gry:");
        switch (userOption) {
            case 1:
                RockPaperScissorsBuilder.build().start();
                break;
            case 2:
                System.out.println("Implement me 🤣🤣");
                break;
            case 3:
                System.out.println("Implement me 🤣🤣");
                break;
            case 4:
                System.out.println("Implement me 🤣🤣");
                break;
            case 5:
                return;
            default:
                System.out.println("Option Not recognized");
        }
    }
}
