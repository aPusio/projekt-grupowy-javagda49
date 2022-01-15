package com.sda.games.r_p_s.game;

import com.sda.games.r_p_s.game.menu.RockPaperScissorsMenu;
import com.sda.utils.UserIoService;

public class RockPaperScissorsBuilder {


    public static RockPaperScissors build() {
        UserIoService userIoService = new UserIoService();
        return new RockPaperScissors(
                userIoService,
                new RockPaperScissorsMenu(),
                new RockPaperScissorsGame());
    }
}