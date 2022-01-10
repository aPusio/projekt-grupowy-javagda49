package com.sda.games.checkers.model.player;

import lombok.*;

import java.util.List;

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

    public Player switchPlayers(Player player, List<Player> players) {
        return player.isWhite() ? players.get(1) : players.get(0);
    }
}
