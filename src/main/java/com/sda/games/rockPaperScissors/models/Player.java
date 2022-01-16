package com.sda.games.rockPaperScissors.models;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class Player {
    private Integer id;
    private String nickname;
    private boolean isHuman;
    private Symbol symbol;
    private Integer score;

    public Player(boolean isHuman, int score) {
        this.isHuman = isHuman;
        this.score = score;
    }

    public Player(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSymbol(int symbolNumber) {
        switch (symbolNumber){
            case 1:
                this.symbol = Symbol.ROCK;
                break;
            case 2:
                this.symbol = Symbol.PAPER;
                break;
            case 3:
                this.symbol = Symbol.SCISSORS;
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
