package com.sda.games.rockPaperScissors.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Round {
    private int roundCounter;
    private final int MAX_ROUNDS = 3;
    private final int STARTING_ROUND = 1;
}
