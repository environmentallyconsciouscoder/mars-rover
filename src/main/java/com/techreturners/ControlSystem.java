package com.techreturners;

interface ControlSystem {
    void turnRight(Vehicle vehicle, char cardinalDirection);
    void turnLeft(Vehicle vehicle, char cardinalDirection);
    void moveForward(Vehicle vehicle, char cardinalDirection);
}
