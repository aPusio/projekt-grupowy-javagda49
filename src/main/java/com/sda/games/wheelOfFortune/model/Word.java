package com.sda.games.wheelOfFortune.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wordId;
    private String word;
    @ManyToOne
    private Integer categoryId;
    @ManyToOne
    private WheelOfFortune wheelOfFortune;
}
