package com.sda.games.angrynerds.game;

import com.sda.games.angrynerds.game.map.AngryNerdsDisplay;
import com.sda.games.angrynerds.game.map.AngryNerdsMap;
import com.sda.games.angrynerds.game.map.AngryNerdsMapObjects;
import com.sda.games.angrynerds.game.map.DisplayPixel;
import com.sda.utils.TextColor;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.stream.IntStream;

@AllArgsConstructor
public class AngryNerdsGame {
    private final static int NUMBER_OF_TURNS = 3;
    private AngryNerdsDisplay angryNerdsDisplay;
    private AngryNerdsUserIo angryNerdsUserIo;

    public void start() {
        IntStream.range(0, NUMBER_OF_TURNS)
                .forEach(turnNumber -> {
                    Optional<Vector> vectorFromUser = angryNerdsUserIo.getVectorFromUser();
                    AngryNerdsMap angryNerdsMap = new AngryNerdsMap();
                    angryNerdsMap.merge(AngryNerdsMapObjects.thrower());
                    angryNerdsMap.merge(AngryNerdsMapObjects.target());
                    angryNerdsDisplay.printOnScreen(angryNerdsMap);
                    if (vectorFromUser.isPresent()) {
                        Vector vector = vectorFromUser.get();
                        Position angryNerd = Position.of(0, 0);
                        AngryNerdsTarget.NERD_STATE nerdState = AngryNerdsTarget.checkHit(angryNerd);
                        while (nerdState == AngryNerdsTarget.NERD_STATE.BEFORE_TARGET) {
                            angryNerd = vector.apply(angryNerd);
                            vector = vector.next();
                            angryNerdsMap.tryToPut(angryNerd, new DisplayPixel("#", TextColor.ANSI_RED));
                            nerdState = AngryNerdsTarget.checkHit(angryNerd);
                            angryNerdsDisplay.printOnScreen(angryNerdsMap);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (nerdState == AngryNerdsTarget.NERD_STATE.INSIDE_TARGET) {
                            angryNerdsUserIo.congratulations();
                        }
                    }
                });
    }
}
