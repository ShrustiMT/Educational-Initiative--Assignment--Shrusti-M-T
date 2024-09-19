
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Main class to run the simulation
public class MarsRoverSimulation2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Initialize Grid
        Grid grid = new Grid(10, 10);
        System.out.print("Enter number of obstacles: ");
        int numObstacles = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<numObstacles; i++){
            System.out.print("Enter obstacle " + (i+1) + " position (x y): ");
            String[] obstacleInput = scanner.nextLine().split(" ");
            int ox = Integer.parseInt(obstacleInput[0]);
            int oy = Integer.parseInt(obstacleInput[1]);
            try {
                grid.addObstacle(new Position(ox, oy));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--; // Retry current obstacle
            }
        }

        // Initialize Rover with user-defined starting position and direction
        System.out.print("Enter Rover starting position (x y): ");
        String[] startPosInput = scanner.nextLine().split(" ");
        if(startPosInput.length != 2){
            System.out.println("Invalid input. Defaulting to (0,0).");
            startPosInput = new String[]{"0", "0"};
        }
        int startX = Integer.parseInt(startPosInput[0]);
        int startY = Integer.parseInt(startPosInput[1]);

        System.out.print("Enter Rover starting direction (N, E, S, W): ");
        String dirInput = scanner.nextLine().toUpperCase();
        Direction startDirection;
        switch(dirInput){
            case "N":
                startDirection = Direction.NORTH;
                break;
            case "E":
                startDirection = Direction.EAST;
                break;
            case "S":
                startDirection = Direction.SOUTH;
                break;
            case "W":
                startDirection = Direction.WEST;
                break;
            default:
                System.out.println("Invalid direction. Defaulting to North.");
                startDirection = Direction.NORTH;
        }

        Rover rover;
        try {
            rover = new Rover(new Position(startX, startY), startDirection, grid);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Defaulting Rover to (0,0) facing North.");
            rover = new Rover(new Position(0, 0), Direction.NORTH, grid);
        }

        // Define Commands
        System.out.print("Enter command sequence (e.g., M M R M M): ");
        String[] commands = scanner.nextLine().split(" ");

        // Map commands to Command objects using a Map to avoid if-else
        Map<String, Command> commandMap = new HashMap<>();
        CommandInvoker invoker = new CommandInvoker();

        // Populate the command map
        commandMap.put("M", new MoveCommand(rover));
        commandMap.put("L", new LeftCommand(rover));
        commandMap.put("R", new RightCommand(rover));

        // Add commands to invoker
        for(String cmdStr : commands){
            Command cmd = commandMap.get(cmdStr.toUpperCase());
            if(cmd != null){
                invoker.addCommand(cmd);
            } else {
                System.out.println("Invalid command encountered and skipped: " + cmdStr);
            }
        }

        // Execute Commands
        invoker.executeCommands();

        // Final Position and Status Report
        System.out.println("Final Position: (" + rover.getPosition().getX() + ", " +
                           rover.getPosition().getY() + ", " + rover.getDirection().toString().charAt(0) + ")");
        System.out.println("Status Report: \"" + rover.getStatusReport() + "\"");
    }
}
