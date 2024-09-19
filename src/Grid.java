

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Grid class implementing GridComponent
public class Grid implements GridComponent {
    private final int width;
    private final int height;
    private final Set<Position> obstacles;

    public Grid(int width, int height){
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>();
    }

    public void addObstacle(Position position){
        if(isWithinBounds(position)){
            obstacles.add(position);
        } else {
            throw new IllegalArgumentException("Obstacle position out of grid bounds: " + position);
        }
    }

    @Override
    public boolean isObstacleAt(Position position){
        return obstacles.contains(position);
    }

    public boolean isWithinBounds(Position position){
        return position.getX() >= 0 && position.getX() < width &&
               position.getY() >= 0 && position.getY() < height;
    }

    public Set<Position> getObstacles(){
        return Collections.unmodifiableSet(obstacles);
    }
}