package com.sda.games.checkers.database.model;

import com.sda.games.checkers.logic.game.Game;

import com.sda.games.checkers.logic.player.Move;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity {

    @Id
    @Column(name = "id", nullable = false)
    private int id;


//    private List<Move>

    public GameEntity(Game game){

    }
}
