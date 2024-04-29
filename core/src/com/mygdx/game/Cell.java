package com.mygdx.game;

import java.util.Objects;

public class Cell {
    int xPos;
    int yPos;

    public Cell(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return xPos == cell.xPos && yPos == cell.yPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPos, yPos);
    }
}
