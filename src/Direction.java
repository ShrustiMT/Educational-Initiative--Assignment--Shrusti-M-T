

// Enum for Directions with methods to get left and right directions
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static final Direction[] vals = values();

    public Direction turnLeft() {
        return vals[(this.ordinal() + 3) % 4];
    }

    public Direction turnRight() {
        return vals[(this.ordinal() + 1) % 4];
    }

    @Override
    public String toString() {
        switch(this){
            case NORTH: return "North";
            case EAST: return "East";
            case SOUTH: return "South";
            case WEST: return "West";
            default: return "";
        }
    }
}


