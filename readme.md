# Mars Rover Exercise

## Table Of Contents
*  section 1: Project description
*  section 2: How to install and run the project
*  section 3: Test cases
*  section 4: Approaches 

## Project description

Our MVP includes the ability to rotate the Land Rover by 90 degrees to the left or right, move it forward by one grid, and display its position on a grid in the terminal, with input values fed into unit tests.

We assume that the plateau is a square or rectangular grid.

In the future, we plan to support different shaped plateaus, allow input via a console application, and enable input via a file.

The project is developed using Java, JUnit 5, and Maven.

## Installation

Please ensure that you have Java and Maven installed on your computer. To run the unit tests, use the command 'mvn test'.

## Test cases

We will use unit tests for specific edge cases and parameterized tests for various test cases to cover a wider range of scenarios in my code

| Test Cases                  | Expections |
|-----------------------------|:----------:|
| 1 2 N<br/>LMLMLMLMM         |  1 3 N     |
| 3 3 E<br/>MMRMMRMRRM        |   5 1 E    |


| Edge Cases |    Expections     |
|------------|:-----------------:|
| 1.2 3.4 N  |   invalid input   |
|            |   invalid input   |
| -1 2 H     |   invalid input   |

## Approaches

The plateau is defined by boundaries at (0,0) as the lower-left corner and (5,5) as the upper-right corner by default. These boundaries are represented as:

xMin = 0<br/>
xMax = 5<br/>
yMin = 0<br/>
yMax = 5<br/>

For testing purposes, we will perform the following test case to ensure the position (X, Y) falls within the plateau boundaries:

X should be within the range [xMin, xMax], and Y should be within the range [yMin, yMax].

For the X-coordinate (horizontal axis):

*  If the Land Rover is facing west and moves forward, its new X-coordinate will be X-1.
*  If the Land Rover is facing east and moves forward, its new X-coordinate will be X+1.
*  The Land Rover's X-coordinate (X) should satisfy the condition X >= xMin and X <= xMax to stay within the plateau boundaries.

For the Y-coordinate (vertical axis):

*  If the Land Rover is facing south and moves forward, its new Y-coordinate will be Y-1.
*  If the Land Rover is facing north and moves forward, its new Y-coordinate will be Y+1.
*  The Land Rover's Y-coordinate (Y) should satisfy the condition Y >= yMin and Y <= yMax to stay within the plateau boundaries.

These conditions ensure that the Land Rover can move forward safely within the defined plateau boundaries without going off the edge