package com.sda.games.rockPaperScissors.entity;

import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Scanner;

@Entity
@Getter
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nickname;
    private boolean isHuman;
    private SymbolEntity symbol;
    private int score;

    public PlayerEntity(boolean isHuman, int score) {
        this.isHuman = isHuman;
        this.score = score;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSymbol(int symbolNumber) {
        switch (symbolNumber){
            case 1:
                this.symbol = SymbolEntity.ROCK;
                break;
            case 2:
                this.symbol = SymbolEntity.PAPER;
                break;
            case 3:
                this.symbol = SymbolEntity.SCISSORS;
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
