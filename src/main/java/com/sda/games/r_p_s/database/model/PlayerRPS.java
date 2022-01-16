package com.sda.games.r_p_s.database.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class PlayerRPS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public static void add(PlayerRPS playerRPS1) {

    }
}
