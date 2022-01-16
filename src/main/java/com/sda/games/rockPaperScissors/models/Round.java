package com.sda.games.rockPaperScissors.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Round {
    private int currentRound;
    private final int STARTING_ROUND = 1;
    private final int MAX_ROUNDS = 3;
}
