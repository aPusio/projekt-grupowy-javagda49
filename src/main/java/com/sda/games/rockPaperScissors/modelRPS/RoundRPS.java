package com.sda.games.rockPaperScissors.modelRPS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RoundRPS {
    private int roundCounter;
    private final int MAX_ROUNDS = 3;
    private final int STARTING_ROUND = 1;
}
