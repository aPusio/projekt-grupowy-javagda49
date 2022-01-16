package com.sda.games.rockPaperScissors;

import com.sda.games.rockPaperScissors.dao.EntityDao;
import com.sda.games.rockPaperScissors.dao.PlayerDao;
import com.sda.games.rockPaperScissors.entity.PlayerEntity;
import com.sda.games.rockPaperScissors.models.Player;
import com.sda.games.rockPaperScissors.models.Round;
import com.sda.utils.HibernateFactory;

import java.util.Scanner;

import static com.sda.games.rockPaperScissors.Menu.startMenu;

public class NewRpsGame {

    public void start(){
        Scanner scanner = new Scanner(System.in);
        HibernateFactory hibernateFactory = new HibernateFactory();
        EntityDao<PlayerEntity> genericUserDao = new PlayerDao(hibernateFactory, PlayerEntity.class);

        boolean exitProgram = false;
        while (!exitProgram){
            int getMenuOption = startMenu();
            switch (getMenuOption){
                case 1:
                    boolean matchOver = false;
                    while(!matchOver){
                        GameEngine gameEngine = new GameEngine(
                                new Player(true, 0),
                                new Player(false, 0),
                                new Round(),
                                genericUserDao);
                        gameEngine.startNewGame();
                        System.out.println("Start new match? (y/n)");
                        String decision = scanner.nextLine();
                        if (decision.equals("n") || decision.equals("N")){
                            matchOver = true;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter id of the player you would like to resume: ");
                    int resumeID = scanner.nextInt();
                    GameEngine gameEngine = new GameEngine(
                            new Player(resumeID),
                            new Player(resumeID+1),
                            new Round(),
                            genericUserDao);
                    gameEngine.loadPreviousMatch();
                    break;
                case 3:
                    exitProgram = true;
                    break;
            }
        }

    }
}
