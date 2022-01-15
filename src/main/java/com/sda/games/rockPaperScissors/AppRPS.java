package com.sda.games.rockPaperScissors;

import com.sda.games.rockPaperScissors.daoRPS.EntityDao;
import com.sda.games.rockPaperScissors.daoRPS.UserDaoRPS;
import com.sda.games.rockPaperScissors.modelRPS.RoundRPS;
import com.sda.games.rockPaperScissors.modelRPS.UserRPS;
import com.sda.utils.HibernateFactory;

import java.util.Scanner;

import static com.sda.games.rockPaperScissors.Menu.printMenu;

public class AppRPS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HibernateFactory hibernateFactory = new HibernateFactory();
        EntityDao<UserRPS> genericUserDao = new UserDaoRPS(hibernateFactory, UserRPS.class);
        UserRPS human = new UserRPS(true, 0);
        UserRPS ai = new UserRPS(false, 0);



        printMenu();

        boolean gameOver = false;
        while(!gameOver){
            GameEngineRPS gameEngineRPS = new GameEngineRPS(human, ai, new RoundRPS(), genericUserDao);
            gameEngineRPS.startGame();
            System.out.println("Continue? (y/n)");
            String decision = scanner.nextLine();
            if (decision.equals("n")){
                gameOver = true;
            }
        }
    }
}
