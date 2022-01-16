package com.sda.games.angrynerds;

import com.sda.games.angrynerds.game.AngryNerdsGame;
import com.sda.games.angrynerds.menu.AngryNerdsMenu;
import com.sda.games.angrynerds.menu.MenuOption;
import com.sda.utils.UserIoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AngryNerds {
    private UserIoService userIoService;
    private AngryNerdsMenu angryNerdsMenu;
    private AngryNerdsGame angryNerdsGame;
    public void start(){
        MenuOption chosenOption = angryNerdsMenu.execute(userIoService);
        switch (chosenOption){
            case NEW_GAME:
                angryNerdsGame.start();
        }
    }
}
