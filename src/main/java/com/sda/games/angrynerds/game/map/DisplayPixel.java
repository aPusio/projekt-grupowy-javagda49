package com.sda.games.angrynerds.game.map;

import com.sda.utils.TextColor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class DisplayPixel {

    private String aChar;
    private TextColor color;

    public static DisplayPixel of(String aChar) {
        return new DisplayPixel(aChar, null);
    }

    public static DisplayPixel of(String aChar, TextColor textColor) {
        return new DisplayPixel(aChar, textColor);
    }
}
