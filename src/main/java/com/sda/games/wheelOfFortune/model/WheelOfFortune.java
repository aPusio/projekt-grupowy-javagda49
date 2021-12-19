package com.sda.games.wheelOfFortune.model;

import com.sda.users.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WheelOfFortune {
    private Integer gameId;
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState;
    private boolean turn;
    @OneToMany(mappedBy = "player")
    private List<Player> players;
    @OneToMany(mappedBy = "player")
    private List<Words> wordsList;
}
