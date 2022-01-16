package com.sda.games.angrynerds;

import com.sda.games.angrynerds.game.AngryNerdsGame;
import com.sda.games.angrynerds.menu.AngryNerdsMenu;
import com.sda.games.angrynerds.menu.MenuOption;
import com.sda.utils.HibernateFactory;
import com.sda.utils.UserIoService;
import lombok.AllArgsConstructor;
import org.hibernate.Session;

@AllArgsConstructor
public class AngryNerds {
    private UserIoService userIoService;
    private AngryNerdsMenu angryNerdsMenu;
    private AngryNerdsGame angryNerdsGame;
    public void start(){
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.close();
        hibernateFactory .getSessionFactory().close();

        MenuOption chosenOption = angryNerdsMenu.execute(userIoService);
        switch (chosenOption){
            case NEW_GAME:
                angryNerdsGame.start();
        }
    }
}
