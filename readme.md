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
