package com.sda.games.checkers.model;

public class Player {

    private Integer id;
    private String name;
    private boolean isWhite;

    public Player(Integer id, String name, Boolean isWhite) {
        this.id = id;
        this.name = name;
        this.isWhite = isWhite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

}
