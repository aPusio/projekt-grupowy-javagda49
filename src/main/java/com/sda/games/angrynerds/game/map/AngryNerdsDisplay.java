package com.sda.games.angrynerds.game.map;

import com.sda.games.angrynerds.game.Position;
import com.sda.utils.UserIoService;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.stream.IntStream;

@AllArgsConstructor
public class AngryNerdsDisplay {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 30;
    private UserIoService userIoService;

    public void dummy() {
        IntStream.range(0, MAX_HEIGHT).forEach(b -> {
            IntStream.range(0, MAX_WIDTH).forEach(a -> System.out.print("."));
            System.out.println();
        });
    }

    public void printOnScreen(AngryNerdsMap angryNerdsMap) {
        userIoService.clearScreen();
        for (int y = MAX_HEIGHT - 1; y >= 0; y--) {
            for (int x = 0; x < MAX_WIDTH; x++) {
                Optional<DisplayPixel> optionalPixel = angryNerdsMap.get(Position.of(x, y));
                if (optionalPixel.isPresent()) {
                    DisplayPixel displayPixel = optionalPixel.get();
                    userIoService.printOnScreenWithColor(displayPixel.getAChar(), displayPixel.getColor());
                } else {
                    userIoService.printOnScreen(" ");
                }
            }
            userIoService.printLineEnd();
        }
    }

}
