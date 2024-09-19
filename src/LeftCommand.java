
public class LeftCommand implements Command {
    private final Rover rover;

    public LeftCommand(Rover rover){
        this.rover = rover;
    }

    @Override
    public void execute(){
        rover.turnLeft();
    }
}