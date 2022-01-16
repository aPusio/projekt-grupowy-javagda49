package com.sda.games.angrynerds.game;

import com.sda.games.angrynerds.AngryNerdsMessages;
import com.sda.utils.UserIoService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AngryNerdsUserIo {
    private UserIoService userIoService;

    public Optional<Vector> getVectorFromUser() {
        String stringVector = userIoService.getString(AngryNerdsMessages.getVector);
        String[] split = stringVector.split(",");
        if (split.length < 2) {
            return Optional.empty();
        }
        try {
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            return Optional.of(new Vector(x, y));
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }

    public void congratulations() {
        userIoService.printOnScreen(List.of(
                "=========================",
                "--------GRATULUJE--------",
                "========================="));
    }
}
