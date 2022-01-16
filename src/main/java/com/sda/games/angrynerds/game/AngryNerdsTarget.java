package com.sda.games.angrynerds.game;

import com.sda.games.angrynerds.game.map.AngryNerdsMap;

public class AngryNerdsTarget {
    public static final int TARGET_SIZE = 5;
    public static final int minY = 0;
    public static final int maxY = TARGET_SIZE;
    public static final int minX = AngryNerdsMap.MAX_WIDTH - TARGET_SIZE;
    public static final int maxX = AngryNerdsMap.MAX_WIDTH;

    public static NERD_STATE checkHit(Position position) {
        if (position.getX() >= minX && position.getX() <= maxX && position.getY() <= maxY && position.getY() >= minY) {
            return NERD_STATE.INSIDE_TARGET;
        }
        if (position.getX() > maxX || position.getY() < minY) {
            return NERD_STATE.AFTER_TARGET;
        }
        return NERD_STATE.BEFORE_TARGET;
    }

    public enum NERD_STATE {
        BEFORE_TARGET,
        INSIDE_TARGET,
        AFTER_TARGET
    }
}
