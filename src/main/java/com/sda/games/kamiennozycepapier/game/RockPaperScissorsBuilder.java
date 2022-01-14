package com.sda.games.kamiennozycepapier.game;

import com.sda.games.kamiennozycepapier.game.manu.RockPaperScissorsMenu;
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