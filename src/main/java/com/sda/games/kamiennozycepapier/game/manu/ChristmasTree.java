package com.sda.games.kamiennozycepapier.game.manu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class ChristmasTree {


    public ChristmasTree(char sign, int numberOfSignsAtTheBoottom) {

        int numberOfSignsAtTheTop = numberOfSignsAtTheBoottom % 2 == 0 ? 2 : 1;

        int height = 0;
        for (int i = numberOfSignsAtTheBoottom; i > 0; i = i - 2) {
            height++;
        }

        int numberOfSingsInARow = numberOfSignsAtTheTop;
        for (int row = 0; row < height; row++) {
            int numberOfSpace = (numberOfSignsAtTheBoottom - numberOfSingsInARow) / 2;

            for (int column = 0;
                 column < numberOfSignsAtTheBoottom - numberOfSpace;
                 column++
            ) {
                System.out.print(column < numberOfSpace ? " " : sign);
            }
            numberOfSingsInARow = numberOfSingsInARow + 2;
            System.out.println();
        }
    }

}
