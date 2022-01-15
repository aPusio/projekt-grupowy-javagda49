package com.sda.games.checkers.database.model;

import com.sda.games.checkers.logic.player.Player;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "playerName")
    private String name;
    private boolean isWhite;
    public int kills;

    public PlayerEntity(Player player) {
        this.name = player.getName();
        this.isWhite = player.isWhite();
        this.kills = player.getKills();
    }
}
