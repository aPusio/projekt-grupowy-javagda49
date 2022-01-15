package com.sda.games.rockPaperScissors;

import com.sda.games.rockPaperScissors.daoRPS.EntityDao;
import com.sda.games.rockPaperScissors.modelRPS.RoundRPS;
import com.sda.games.rockPaperScissors.modelRPS.SymbolRPS;
import com.sda.games.rockPaperScissors.modelRPS.UserRPS;
import lombok.AllArgsConstructor;
import java.util.Random;
import java.util.Scanner;

@AllArgsConstructor
public class GameEngineRPS {
    private UserRPS human;
    private UserRPS ai;
    private RoundRPS round;
    private EntityDao<UserRPS> genericUserDao;

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        round.setRoundCounter(round.getSTARTING_ROUND());
        System.out.println("Player enter your name:");
        human.setNickname(scanner.nextLine());
        System.out.println("Hello " + human.getNickname() + ". Thank you for choosing our game, good luck !!");

        genericUserDao.save(human);

        while(round.getRoundCounter() <= round.getMAX_ROUNDS()){
            System.out.println("Round: " + round.getRoundCounter());
            humanMove();
            aiMove();
            System.out.println("AI picked " + ai.getSymbol());
            round.setRoundCounter(round.getRoundCounter()+1);
            increaseWinnersScore(human.getSymbol(), ai.getSymbol());
            System.out.println("Human " + human.getScore() + " vs AI " + ai.getScore());
            System.out.println();
        }
        printWinner();
    }

    private void printWinner() {
        if (human.getScore() == ai.getScore()){
            System.out.println("Its a tie!");
        }else {
            System.out.println(human.getScore() > ai.getScore() ? "You wonn!" : "Ai wonn!");
        }
    }

    private void increaseWinnersScore(Enum<SymbolRPS> humanSymbol, Enum<SymbolRPS> aiSymbol) {
        if (humanSymbol.equals(aiSymbol)){
            System.out.println("Tie!");
        }
        else if (humanSymbol.equals(SymbolRPS.ROCK) && (aiSymbol.equals(SymbolRPS.SCISSORS))){
            human.setScore(human.getScore()+1);
        }
        else if (humanSymbol.equals(SymbolRPS.SCISSORS) && (aiSymbol.equals(SymbolRPS.PAPER))){
            human.setScore(human.getScore()+1);
        }
        else if (humanSymbol.equals(SymbolRPS.PAPER) && (aiSymbol.equals(SymbolRPS.ROCK))){
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
