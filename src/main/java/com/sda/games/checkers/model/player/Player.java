package com.sda.games.checkers.model.player;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private int id;
    private String name;
    private boolean isWhite;
    public static String whitePlayerName;
    public static String blackPlayerName;
    public int kills = 0;

    public void killCounter() {
        kills += 1;
    }

    public boolean isBlack() {
        return !isWhite;
    }
}
