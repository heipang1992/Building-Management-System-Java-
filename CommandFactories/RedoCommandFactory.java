package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;

public class RedoCommandFactory implements CommandFactory{

    private Stack commands;
    private Stack redos;
    private Caretaker ct;
    
    public RedoCommandFactory(Stack commands, Stack redos, Caretaker ct){
        this.commands = commands;
        this.redos = redos;
        this.ct = ct;
    }
    public Command createCommand(){
        Command c  = new RedoCommand(commands, redos, ct);
        return c;
    }
    
}
