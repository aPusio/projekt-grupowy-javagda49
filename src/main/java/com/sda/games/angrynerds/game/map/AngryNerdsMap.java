package com.sda.games.angrynerds.game.map;

import com.sda.games.angrynerds.game.Position;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AngryNerdsMap {
    public static final int MAX_WIDTH = 200;
    public static final int MIN_WIDTH = 0;
    public static final int MAX_HEIGHT = 30;
    public static final int MIN_HEIGHT = 0;
    public Map<Position, DisplayPixel> map = new HashMap<>();

    public boolean tryToPut(Position position, DisplayPixel displayPixel) {
        if (position.getX() >= MIN_WIDTH && position.getX() <= MAX_WIDTH && position.getY() >= MIN_HEIGHT && position.getY() <= MAX_HEIGHT) {
            map.put(position, displayPixel);
            return true;
        }
        return false;
    }

    public void merge(AngryNerdsMap angryNerdsMap) {
        map.putAll(angryNerdsMap.getMap());
    }

    public Optional<DisplayPixel> get(Position position) {
        return Optional.ofNullable(map.get(position));
    }

    protected Map<Position, DisplayPixel> getMap() {
        return new HashMap<>(map);
    }

}
