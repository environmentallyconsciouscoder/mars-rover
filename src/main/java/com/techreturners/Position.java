package com.techreturners;

import java.util.ArrayList;

public class Position {
    private char cardinalDirection;
    private int yValue;
    private int xValue;

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

    public void setCardinalDirection(char cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public void setYValue(int yValue) {
        this.yValue = yValue;
    }

    public void setXValue(int xValue) {
        this.xValue = xValue;
    }
}
