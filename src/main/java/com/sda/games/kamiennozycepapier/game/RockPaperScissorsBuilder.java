package com.sda.games.kamiennozycepapier.game;

import com.sda.utils.UserIoService;

public class RockPaperScissorsBuilder {

    public static RockPaperScissors build() {
        UserIoService userIoService = new UserIoService();
        RockPaperScissors rockPaperScissors = new RockPaperScissors(
                userIoService,
                new RockPaperScissorsGame());
        return rockPaperScissors;
    }

}