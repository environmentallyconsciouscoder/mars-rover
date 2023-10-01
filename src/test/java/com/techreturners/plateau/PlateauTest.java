package com.techreturners.plateau;

import com.techreturners.plateau.Plateau;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {

    @Test
    public void testPlateau() {

        int minX = 0;
        int maxX = 5;

        int minY = 0;
        int maxY = 5;

        Plateau plateau = new Plateau(minX, maxX, minY, maxY);

        assertEquals(minX, plateau.getMinX());
        assertEquals(maxX, plateau.getMaxX());
        assertEquals(minY, plateau.getMinY());
        assertEquals(maxY, plateau.getMaxY());
    }
}
