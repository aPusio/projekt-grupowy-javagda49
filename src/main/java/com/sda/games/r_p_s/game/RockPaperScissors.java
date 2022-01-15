package com.sda.games.r_p_s.game;

import com.sda.games.r_p_s.game.menu.MenuOption;
import com.sda.games.r_p_s.game.menu.RockPaperScissorsMenu;
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
