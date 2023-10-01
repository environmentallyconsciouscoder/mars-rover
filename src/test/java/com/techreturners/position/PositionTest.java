package com.techreturners.position;

import com.techreturners.position.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    public void testPosition() {

        int xValue = 1;
        int yValue = 2;
        char cardinalDirection = 'N';

        Position position = new Position(xValue, yValue, cardinalDirection);

        assertEquals(yValue, position.getYValue());
        assertEquals(xValue, position.getXValue());
        assertEquals(cardinalDirection, position.getCardinalDirection());

    }
}
