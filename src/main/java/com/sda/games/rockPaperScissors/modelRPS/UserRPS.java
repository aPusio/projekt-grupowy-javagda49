package com.sda.games.rockPaperScissors.modelRPS;

import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Scanner;

@Entity
@Getter
public class UserRPS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nickname;
    private boolean isHuman;
    private SymbolRPS symbol;
    private int score;

    public UserRPS(boolean isHuman, int score) {
        this.isHuman = isHuman;
        this.score = score;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSymbol(int symbolNumber) {
        switch (symbolNumber){
            case 1:
                this.symbol = SymbolRPS.ROCK;
                break;
            case 2:
                this.symbol = SymbolRPS.PAPER;
                break;
            case 3:
                this.symbol = SymbolRPS.SCISSORS;
                break;
            default:
                System.out.println("Something went wrong");
                System.out.println("Enter proper number");
                Scanner scanner = new Scanner(System.in);
                setSymbol(scanner.nextInt());
        }
    }

    public void setScore(int score) {
        this.score = score;
    }
}
