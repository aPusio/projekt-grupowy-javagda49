package com.sda.games.kamiennozycepapier.game.manu;

import com.sda.utils.UserIoService;

import java.util.Arrays;

public class RockPaperScissorsMenu {

    public MenuOption execute(UserIoService userIoService) {
        printMenu(userIoService);
        Integer userInput = userIoService.getInt(RockPaperScissorsMessages.pickOptionNumber);
        return MenuOption.getByNumber(userInput)
                .orElseThrow(MenuOptionNotRecognized::new);
    }

    private void printMenu(UserIoService userIoService) {
        userIoService.clearScreen();
        userIoService.printOnScreen(RockPaperScissorsMessages.gameEdition);
        userIoService.printOnScreen(RockPaperScissorsMessages.menuHeader);
        Arrays.stream(MenuOption.values())
                .map(MenuOption::getNumberAndText)
                .peek(userIoService::printOnScreen)
                .forEach(a -> userIoService.printLineEnd());
    }
}

