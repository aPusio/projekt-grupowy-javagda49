package com.sda.games.rockPaperScissors;

import com.sda.games.rockPaperScissors.dao.EntityDao;
import com.sda.games.rockPaperScissors.models.Player;
import com.sda.games.rockPaperScissors.models.Round;
import com.sda.games.rockPaperScissors.models.Symbol;
import com.sda.games.rockPaperScissors.entity.PlayerEntity;
import lombok.AllArgsConstructor;
import java.util.Random;
import java.util.Scanner;

@AllArgsConstructor
public class GameEngine {
    private Player human;
    private Player ai;
    private Round round;
    private EntityDao<PlayerEntity> genericUserDao;

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        round.setRoundCounter(round.getSTARTING_ROUND());
        System.out.println("Player enter your name:");
        human.setNickname(scanner.nextLine());
        System.out.println("Hello " + human.getNickname() + ". Thank you for choosing our game, good luck !!");
        ai.setNickname("AI");

        PlayerEntity humanEntity = new PlayerEntity(human.getNickname(), human.getScore());
        genericUserDao.save(humanEntity);
        PlayerEntity aiEntity = new PlayerEntity(ai.getNickname(), ai.getScore());
        genericUserDao.save(aiEntity);

        while(round.getRoundCounter() <= round.getMAX_ROUNDS()){
            System.out.println("Round: " + round.getRoundCounter());
            humanMove();
            aiMove();
            System.out.println(ai.getNickname() + " picked " + ai.getSymbol());
            round.setRoundCounter(round.getRoundCounter()+1);
            increaseWinnersScore(human.getSymbol(), ai.getSymbol());
            System.out.println(human.getNickname() + " " + human.getScore() + " vs AI " + ai.getScore());
            System.out.println();
            updatePlayersDB(humanEntity, aiEntity);
            if (human.getScore() == 3 || ai.getScore() == 3){
                printWinner();
                break;
            }else {
                System.out.println("Need a break? y/n");
                String decision = scanner.nextLine();
                if (decision.equals("y")){
                    System.out.println("Match paused");
                    break;
                }
            }
        }
        loadPreviousMatch();
    }

    private void updatePlayersDB(PlayerEntity humanEntity, PlayerEntity aiEntity) {
        humanEntity.setScore(human.getScore());
        genericUserDao.update(humanEntity);
        aiEntity.setScore(ai.getScore());
        genericUserDao.update(aiEntity);
    }

    private void loadPreviousMatch() {
    }

    private void printWinner() {
        if (human.getScore() == ai.getScore()){
            System.out.println("Its a tie!");
        }else {
            System.out.println(human.getScore() > ai.getScore() ? "You wonn!" : "Ai wonn!");
        }
    }

    private void increaseWinnersScore(Enum<Symbol> humanSymbol, Enum<Symbol> aiSymbol) {
        if (humanSymbol.equals(aiSymbol)){
            human.setScore(human.getScore()+1);
            ai.setScore(ai.getScore()+1);
        }
        else if (humanSymbol.equals(Symbol.ROCK) && (aiSymbol.equals(Symbol.SCISSORS))){
            human.setScore(human.getScore()+1);
        }
        else if (humanSymbol.equals(Symbol.SCISSORS) && (aiSymbol.equals(Symbol.PAPER))){
            human.setScore(human.getScore()+1);
        }
        else if (humanSymbol.equals(Symbol.PAPER) && (aiSymbol.equals(Symbol.ROCK))){
            human.setScore(human.getScore()+1);
        }
        else{
            ai.setScore(ai.getScore()+1);
        }
    }

    private void aiMove() {
        Random random = new Random();
        int symbol = random.nextInt(3) + 1;
        ai.setSymbol(symbol);
    }

    private void humanMove() {
        System.out.println("Wybierz liczbe przyporzadkowana do symbolu:");
        System.out.println("1.ROCK, 2.PAPER, 3.SCISSORS");
        Scanner scanner = new Scanner(System.in);
        int symbol = scanner.nextInt();
        human.setSymbol(symbol);
    }
}