## Folder Structure

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
