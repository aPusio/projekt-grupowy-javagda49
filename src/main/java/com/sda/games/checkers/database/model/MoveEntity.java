package com.sda.games.checkers.database.model;

import com.sda.games.checkers.logic.player.Move;
import com.sda.games.checkers.logic.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int moveNumber;
    private String playerName;
    private String startSpot;
    private String endSpot;
    private boolean isWhite;

    public MoveEntity (int moveNumber, String playerName, String  startSpot, String endSpot, boolean isWhite) {
        this.moveNumber = moveNumber;
        this.playerName = playerName;
        this.startSpot = startSpot;
        this.endSpot = endSpot;
        this.isWhite = isWhite;
    }
}
