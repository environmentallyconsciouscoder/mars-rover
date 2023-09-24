package com.techreturners;

public class Plateau {
//    private static int minX = 0;
//    private static int maxX = 5;
//    private static int minY = 0;
//    private static int maxY = 5;

    private int minX = 0;
    private int maxX = 5;
    private int minY = 0;
    private int maxY = 5;

    public Plateau(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;

        this.minY = minY;
        this.maxY = maxY;
    }

//    public static int getMinX() {
//        return minX;
//    }
//
//    public static int getMaxX() {
//        return maxX;
//    }
//
//    public static int getMinY() {
//        return minY;
//    }
//
//    public static int getMaxY() {
//        return maxY;
//    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }
}
