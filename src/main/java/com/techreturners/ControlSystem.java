package com.techreturners;

interface ControlSystem {
    void turnRight(Vehicle vehicle, char cardinalDirection);
    void turnLeft(Vehicle vehicle, char cardinalDirection);
    void moveForward(Vehicle vehicle, char cardinalDirection);

    boolean isMoveWithinBounds(int newCoordinateValue, char axis);

    boolean isThereCollision(Vehicle vehicle, int newCoordinateValue, char axis);
}
