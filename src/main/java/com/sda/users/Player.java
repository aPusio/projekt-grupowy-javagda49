package com.sda.users;

import com.sda.games.wheelOfFortune.model.WheelOfFortune;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;
    private String name;
    private String surname;
    @ManyToOne
    private WheelOfFortune wheelOfFortune;
}
