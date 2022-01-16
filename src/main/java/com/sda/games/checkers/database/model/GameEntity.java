package com.sda.games.checkers.database.model;

import com.sda.games.checkers.logic.game.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
