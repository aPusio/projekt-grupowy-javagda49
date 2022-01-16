package com.sda.games.angrynerds.game.map;

import com.sda.games.angrynerds.game.Position;
import com.sda.utils.TextColor;

import java.util.stream.IntStream;

import static com.sda.games.angrynerds.game.AngryNerdsTarget.TARGET_SIZE;

public class AngryNerdsMapObjects {


    public static AngryNerdsMap thrower() {
        AngryNerdsMap angryNerdsMap = new AngryNerdsMap();
        angryNerdsMap.tryToPut(Position.of(0, 0), DisplayPixel.of("S", TextColor.ANSI_CYAN));
        return angryNerdsMap;
    }

    public static AngryNerdsMap target() {
        AngryNerdsMap angryNerdsMap = new AngryNerdsMap();
        IntStream.range(0, TARGET_SIZE).forEach(y -> {
            IntStream.range(AngryNerdsMap.MAX_WIDTH - TARGET_SIZE, AngryNerdsMap.MAX_WIDTH).forEach(x -> {
                angryNerdsMap.tryToPut(Position.of(x,y), DisplayPixel.of("T", TextColor.ANSI_GREEN));
            });
        });
        return angryNerdsMap;
    }
}
