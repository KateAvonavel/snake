package com.mygdx.game;

public enum Direction {
    UP (Orientation.VERTICAL),
    LEFT (Orientation.HORIZONTAL),
    RIGHT (Orientation.HORIZONTAL),
    DOWN (Orientation.VERTICAL);

    public boolean canChangeInto(Direction direction) {
        return this.orientation != direction.orientation;
    }

    private final Orientation orientation;

    Direction(Orientation orientation) {
        this.orientation = orientation;
    }

    private enum Orientation {
        VERTICAL,
        HORIZONTAL
    }
}

