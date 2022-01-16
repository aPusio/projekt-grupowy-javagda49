package com.sda.games.rockPaperScissors;

import com.sda.games.rockPaperScissors.dao.EntityDao;
import com.sda.games.rockPaperScissors.dao.PlayerDaoRPS;
import com.sda.games.rockPaperScissors.models.Player;
import com.sda.games.rockPaperScissors.models.Round;
import com.sda.games.rockPaperScissors.entity.PlayerEntity;
import com.sda.utils.HibernateFactory;

import java.util.Scanner;

import static com.sda.games.rockPaperScissors.Menu.printMenu;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HibernateFactory hibernateFactory = new HibernateFactory();
        EntityDao<PlayerEntity> genericUserDao = new PlayerDaoRPS(hibernateFactory, PlayerEntity.class);
        Player human = new Player(true, 0);
        Player ai = new Player(false, 0);

        printMenu();

        boolean gameOver = false;
        while(!gameOver){
            GameEngine gameEngineRPS = new GameEngine(human, ai, new Round(), genericUserDao);
            gameEngineRPS.startGame();
            System.out.println("Continue? (y/n)");
            String decision = scanner.nextLine();
            if (decision.equals("n") || decision.equals("N")){
                gameOver = true;
            }
        }
    }
}
