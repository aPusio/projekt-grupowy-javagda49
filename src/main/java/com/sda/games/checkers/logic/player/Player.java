package com.sda.games.checkers.logic.player;

import com.sda.games.checkers.database.model.PlayerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private String name;
    private boolean isWhite;
    public static String whitePlayerName;
    public static String blackPlayerName;
    public int kills = 0;

    public Player(PlayerEntity playerEntity) {
        this.name = playerEntity.getName();
        this.isWhite = playerEntity.isWhite();
        this.kills = playerEntity.getKills();
    }

    public void killCounter() {
        kills += 1;
    }

    public boolean isBlack() {
        return !isWhite;
    }

    public Player switchPlayers(Player player, List<Player> players) {
        return player.isWhite() ? players.get(1) : players.get(0);
    }

    @Override
    public String toString() {
        return "Player{" +
                ", name='" + name + '\'' +
                ", isWhite=" + isWhite +
                ", kills=" + kills +
                '}';
    }
}
