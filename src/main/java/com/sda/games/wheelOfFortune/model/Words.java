package com.sda.games.wheelOfFortune.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Words {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer word_id;
    private String word;
    @ManyToOne
    private Categories category_id;
    @ManyToOne
    private WheelOfFortune wheelOfFortune;
}
