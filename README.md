![{DB9EAB0A-3529-498A-AF61-6C1F447FC0A2}](https://github.com/user-attachments/assets/1fbdad7a-7867-4b27-9c2f-fe57c8c907f7)## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies


## Explanation of the Code: 
1. Direction Enumerations (Direction)

Defines the four cardinal directions - NORTH, EAST, SOUTH, WEST
Provides methods turnLeft() and turnRight() to get a new direction based on a turn
Overrides toString() method to return a meaningful value describing the direction - "North", etc.

2. Position Class (Position)

Encapsulates the coordinates x and y on the grid
Methods Provides for moving in a particular direction by move(Direction direction).
Overrides equals, hashCode, and toString methods for correct comparison and representation.

3. Grid and Obstacle Representation (GridComponent, Grid):---

Composite Pattern: The Grid class implements the GridComponent interface and retains a collection of obstacles.
addObstacle(Position position): Places an obstacle in the grid once it is bounded.
isObstacleAt(Position position): Checks whether a given position contains an obstacle
isWithinBounds(Position position): It ensures that the position falls within the grid's boundary.

4. Rover Class (Rover): End.

Intermingle with the Grid to execute the movements and turns.
Tracks whether an obstacle was met in a try to move (obstacleDetected).
Provides a getStatusReport() method to generate the status report based on the state of the Rover

5. Command Pattern Implementation (Command, MoveCommand, LeftCommand, RightCommand):

Command Interface: Defines the execute() method.
Concrete Commands: All of the commands, namely, MoveCommand, LeftCommand, and RightCommand, encapsulate the operation to be performed on the Rover.
Commands are tied to their string representation through a Map and the need for conditional statements is waived.

6. Command Invoker (CommandInvoker):

Requests a queue of Command objects.
Provides an executeCommands() method which will execute all of the queued commands in succession.

7. Main Application (MarsRoverSimulation):

Creates the grid and adds some obstacles.
Creates the Rover with an initial position and direction.
Ties a explicit sequence of commands, for example: { "M", "M", "R", "M", "M" }.
Map the command strings to their actual associated Command objects using a Map.
Use the CommandInvoker to execute the sequence of commands
Print out the final position and status report in the required format.
"""
EDUCATIONAL_INITIATIVE/
├── src/
│   └── EDUCATIONAL_INITIATIVE/
│       ├── Command.java
│       ├── CommandInvoker.java
│       ├── LeftCommand.java
│       ├── MarsRoverSimulation2.java
│       ├── MoveCommand.java
│       ├── Position.java
│       ├── Grid.java
│       ├── GridComponent.java
│       ├── Rover.java
│       ├── RightCommand.java
│       └── Direction.java
"""
## Key Features of the Implementation
--> Randomized initial position and direction:
* The Rover may be initialized with an arbitrary initial position and direction within the grid.

--> Command Handling at runtime:
* The Command Pattern is used to handle commands abstrc-tly. Every action-Move, Left, Right-is encapsulated as a distinct object.
* A Map is used to associate strings representing commands with their corresponding Command objects; no if statements.

--> Obstacle Detection and Boundary Enforcement:
* The Rover acts on a Grid, with obstacles. Movement is forbidden if an obstacle is encountered or by trying to move out of the grid.

-->Status Reporting:
* After executing the command sequence, the Rover gives a final position and status report providing its state at that point and whether it encountered any obstacles en route.

-->Design Patterns and OOP Principles:
* Command Pattern: Actions are encapsulated as Command objects like MoveCommand, LeftCommand, and RightCommand.
* Composite Pattern: A variation of implementation of the grid classes Grid and Obstacle.
* Encapsulation, Inheritance, Polymorphism: A clean and maintainable codebase.
