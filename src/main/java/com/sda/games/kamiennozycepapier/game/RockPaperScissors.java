package com.sda.games.kamiennozycepapier.game;

import com.sda.utils.UserIoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class RockPaperScissors {

    private UserIoService userIoService;
    private RockPaperScissorsGame rockPaperScissorsGame;

    public void start() {
        rockPaperScissorsGame.start();

    }
}

