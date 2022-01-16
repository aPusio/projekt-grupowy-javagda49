package com.sda.games.angrynerds;

import com.sda.games.angrynerds.game.AngryNerdsUserIo;
import com.sda.games.angrynerds.game.map.AngryNerdsDisplay;
import com.sda.games.angrynerds.game.AngryNerdsGame;
import com.sda.games.angrynerds.menu.AngryNerdsMenu;
import com.sda.utils.UserIoService;

public class AngryNerdsBuilder {
    public static AngryNerds build() {
        UserIoService userIoService = new UserIoService();
        return new AngryNerds(
                userIoService,
                new AngryNerdsMenu(),
                new AngryNerdsGame(new AngryNerdsDisplay(userIoService), new AngryNerdsUserIo(userIoService))
        );
    }
}
