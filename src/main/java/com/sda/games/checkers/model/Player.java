package com.sda.games.checkers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private Integer id;
    private String name;
    private boolean isWhite;
    static String whitePlayerName;
    static String blackPlayerName;

}
