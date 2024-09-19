public class MoveCommand implements Command {
    private final Rover rover;

    public MoveCommand(Rover rover){
        this.rover = rover;
    }

    @Override
    public void execute(){
        rover.move();
    }
}
