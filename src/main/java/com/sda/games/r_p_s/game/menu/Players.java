package com.sda.games.r_p_s.game.menu;

import com.sda.games.r_p_s.database.model.PlayerRPS;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Players {
    private PlayerRPS player1;
    private PlayerRPS player2;
    private PlayerRPS current;

    public PlayerRPS next(){
        if(current.equals(player1)){
            current = player2;
            return player2;
        } else {
            current = player1;
            return player1;
        }
    }

}
