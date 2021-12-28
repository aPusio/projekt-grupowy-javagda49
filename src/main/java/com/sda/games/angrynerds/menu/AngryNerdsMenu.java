package com.sda.games.angrynerds.menu;

import com.sda.games.angrynerds.AngryNerdsMessages;
import com.sda.utils.UserIoService;

import java.util.Arrays;

public class AngryNerdsMenu {

    public MenuOption execute(UserIoService userIoService) {
        printMenu(userIoService);
        Integer userInput = userIoService.getInt(AngryNerdsMessages.pickOptionNumber);
        return MenuOption.getByNumber(userInput)
                .orElseThrow(MenuOptionNotRecognized::new);
    }

    private void printMenu(UserIoService userIoService) {
        userIoService.clearScreen();
        userIoService.printOnScreen(AngryNerdsMessages.menuHeader);
        Arrays.stream(MenuOption.values())
                .map(MenuOption::getNumberAndText)
                .peek(userIoService::printOnScreen)
                .forEach(a -> userIoService.printLineEnd());
    }
}


