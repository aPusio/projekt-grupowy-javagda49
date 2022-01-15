package com.sda.games.r_p_s.game.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum MenuOption {

    NEW_GAME(RockPaperScissorsMessages.newGame, 1),
    CONTINUE(RockPaperScissorsMessages.con, 2),
    EXIT(RockPaperScissorsMessages.exit, 3);


    private String text;
    private Integer number;

    public static Optional<MenuOption> getByNumber(Integer number) {
        return Arrays.stream(MenuOption.values())
                .filter(opt -> Objects.equals(opt.getNumber(), number))
                .findFirst();

    }

    public String getNumberAndText() {
        return number + ". " + text;
    }


}
