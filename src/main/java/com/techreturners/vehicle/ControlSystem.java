package com.techreturners.vehicle;

interface ControlSystem {
    void turnRight(Vehicle vehicle);

    void turnLeft(Vehicle vehicle);

    void moveForward(Vehicle vehicle);

    boolean isMoveWithinBounds(int newCoordinateValue, char axis);

    boolean isThereCollision(Vehicle vehicle, int newCoordinateValue, char axis);
}
