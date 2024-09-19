public class RightCommand implements Command {
    private final Rover rover;

    public RightCommand(Rover rover){
        this.rover = rover;
    }

    @Override
    public void execute(){
        rover.turnRight();
    }
}
