package com.techreturners;

import java.util.ArrayList;

public class Position {
    private final char cardinalDirection;
    private final int yValue;
    private final int xValue;

    public Position(int xValue, int yValue, char cardinalDirection) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.cardinalDirection = cardinalDirection;
    }

    public char getCardinalDirection() {
        return cardinalDirection;
    }

    public int getyValue() {
        return yValue;
    }

    public int getxValue() {
        return xValue;
    }
}
