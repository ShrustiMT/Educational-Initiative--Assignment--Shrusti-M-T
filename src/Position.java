import java.util.Objects;

// Position class to represent coordinates
public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position move(Direction direction){
        switch(direction){
            case NORTH: return new Position(x, y + 1);
            case SOUTH: return new Position(x, y - 1);
            case EAST: return new Position(x + 1, y);
            case WEST: return new Position(x - 1, y);
            default: return this;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Position)) return false;
        Position pos = (Position) o;
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}