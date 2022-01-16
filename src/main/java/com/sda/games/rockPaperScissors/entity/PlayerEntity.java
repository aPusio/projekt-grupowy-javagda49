package com.sda.games.rockPaperScissors.entity;

import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nickname;
    private Integer score;

    public PlayerEntity(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
