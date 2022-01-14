package com.sda.games.checkers.model.player;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "playerName")
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

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isWhite=" + isWhite +
                ", kills=" + kills +
                '}';
    }
}
