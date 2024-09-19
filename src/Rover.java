
public class Rover {
    private Position position;
    private Direction direction;
    private final Grid grid;
    private boolean obstacleDetected;

    public Rover(Position startPosition, Direction startDirection, Grid grid){
        if(!grid.isWithinBounds(startPosition)){
            throw new IllegalArgumentException("Starting position out of grid bounds: " + startPosition);
        }
        this.position = startPosition;
        this.direction = startDirection;
        this.grid = grid;
        this.obstacleDetected = false;
    }

    public void move(){
        Position newPosition = position.move(direction);
        if(grid.isWithinBounds(newPosition) && !grid.isObstacleAt(newPosition)){
            position = newPosition;
        } else {
            obstacleDetected = true;
            // Movement is blocked; Rover stays in the current position
        }
    }

    public void turnLeft(){
        direction = direction.turnLeft();
    }

    public void turnRight(){
        direction = direction.turnRight();
    }

    public Position getPosition(){
        return position;
    }

    public Direction getDirection(){
        return direction;
    }

    public boolean isObstacleDetected(){
        return obstacleDetected;
    }

    public String getStatusReport(){
        String status = "Rover is at " + position + " facing " + direction.toString() + ".";
        status += obstacleDetected ? " Obstacle detected during movement." : " No Obstacles detected.";
        return status;
    }
}