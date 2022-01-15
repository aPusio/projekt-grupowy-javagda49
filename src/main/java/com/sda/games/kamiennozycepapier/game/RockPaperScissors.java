package com.sda.games.kamiennozycepapier.game;

import com.sda.games.kamiennozycepapier.game.manu.MenuOption;
import com.sda.games.kamiennozycepapier.game.manu.RockPaperScissorsMenu;
import com.sda.utils.UserIoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class RockPaperScissors {

    private UserIoService userIoService;
    private RockPaperScissorsMenu rockPaperScissorsMenu;
    private RockPaperScissorsGame rockPaperScissorsGame;

    public void start() {
        MenuOption chosenOption = rockPaperScissorsMenu.execute(userIoService);
        switch (chosenOption) {
            case NEW_GAME:
                rockPaperScissorsGame.start();
            case CONTINUE:
                rockPaperScissorsGame.con();
            case EXIT:
                rockPaperScissorsGame.exit();
        }
    }
}
