import java.util.ArrayList;
import java.util.List;

// Command Invoker
public class CommandInvoker {
    private final List<Command> commandQueue;

    public CommandInvoker(){
        this.commandQueue = new ArrayList<>();
    }

    public void addCommand(Command cmd){
        commandQueue.add(cmd);
    }

    public void executeCommands(){
        for(Command cmd : commandQueue){
            cmd.execute();
        }
    }
}
