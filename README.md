# Game of Life Copy

Game of Life Copy

This is a Java implementation of Conway's Game of Life. It is a simple cellular automaton that simulates the evolution of a grid of cells based on a set of rules.
Rules of the Game

The Game of Life is played on a grid of cells, each of which can be in one of two states: alive or dead. The game evolves in generations, where each generation is determined by the state of the previous generation according to the following rules:

    Any live cell with fewer than two live neighbors dies, as if by underpopulation.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by overpopulation.
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

# Getting Started

To run this game, follow the steps below:

    Clone this repository to your local machine or download the source code as a ZIP file.
    Make sure you have Java Development Kit (JDK) installed on your machine.
    Open the project in your favorite Java IDE.
    Compile and run the GameOfLife.java file.
    The game will be displayed in a graphical window, showing the initial state of the grid.
    Press the "Start" button to start the simulation.
    Watch as the cells evolve and change based on the rules of the game.
    You can pause or stop the simulation at any time using the corresponding buttons.
    Experiment with different initial configurations by modifying the initialState method in the GameOfLife.java file.

# Features

    Graphical user interface (GUI) for a visual representation of the game.
    Pause and stop functionality for controlling the simulation.
    Customizable initial configurations.
