package com.sda.games.rockPaperScissors;

import com.sda.games.rockPaperScissors.dao.EntityDao;
import com.sda.games.rockPaperScissors.dao.PlayerDao;
import com.sda.games.rockPaperScissors.models.Player;
import com.sda.games.rockPaperScissors.models.Round;
import com.sda.games.rockPaperScissors.entity.PlayerEntity;
import com.sda.utils.HibernateFactory;

import java.util.Scanner;

import static com.sda.games.rockPaperScissors.Menu.startMenu;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HibernateFactory hibernateFactory = new HibernateFactory();
        EntityDao<PlayerEntity> genericUserDao = new PlayerDao(hibernateFactory, PlayerEntity.class);
        Player human = new Player(true, 0);
        Player ai = new Player(false, 0);

        boolean exitProgram = false;
        while (!exitProgram){
            int getMenuOption = startMenu();
            switch (getMenuOption){
                case 1:
                    boolean matchOver = false;
                    while(!matchOver){
                        GameEngine gameEngine = new GameEngine(human, ai, new Round(), genericUserDao);
                        gameEngine.startNewGame();
                        System.out.println("Continue? (y/n)");
                        String decision = scanner.nextLine();
                        if (decision.equals("n") || decision.equals("N")){
                            matchOver = true;
                        }
                    }
                    break;
                case 2:
                    GameEngine gameEngine = new GameEngine(genericUserDao);
                    gameEngine.loadPreviousMatch();
                    break;
                case 3:
                    exitProgram = true;
                    break;
            }
        }
    }
}
