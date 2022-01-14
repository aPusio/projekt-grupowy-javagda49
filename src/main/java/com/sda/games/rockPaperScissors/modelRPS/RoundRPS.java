package com.sda.games.rockPaperScissors.modelRPS;

import lombok.*;

import javax.persistence.OneToMany;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RoundRPS {
    private Integer roundId;
    private SymbolRPS symbol;
    private Integer symbol1Id;
    private Integer symbol2Id;

    @OneToMany
    private SymbolRPS symbol1;
    @OneToMany
    private SymbolRPS symbol2;
}