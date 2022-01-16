package com.sda.games.rockPaperScissors;

import com.sda.games.rockPaperScissors.dao.EntityDao;
import com.sda.games.rockPaperScissors.dao.UserDaoRPS;
import com.sda.games.rockPaperScissors.entity.RoundEntity;
import com.sda.games.rockPaperScissors.entity.PlayerEntity;
import com.sda.utils.HibernateFactory;

import java.util.Scanner;

import static com.sda.games.rockPaperScissors.Menu.printMenu;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HibernateFactory hibernateFactory = new HibernateFactory();
        EntityDao<PlayerEntity> genericUserDao = new UserDaoRPS(hibernateFactory, PlayerEntity.class);
        PlayerEntity human = new PlayerEntity(true, 0);
        PlayerEntity ai = new PlayerEntity(false, 0);



        printMenu();

        boolean gameOver = false;
        while(!gameOver){
            GameEngine gameEngineRPS = new GameEngine(human, ai, new RoundEntity(), genericUserDao);
            gameEngineRPS.startGame();
            System.out.println("Continue? (y/n)");
            String decision = scanner.nextLine();
            if (decision.equals("n")){
                gameOver = true;
            }
        }
    }
}
