package com.sda.games.checkers.model;

import lombok.*;

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
