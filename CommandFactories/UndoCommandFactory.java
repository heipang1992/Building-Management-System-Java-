package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;

public class UndoCommandFactory implements CommandFactory{

    private Stack commands;
    private Stack redos;
    private Caretaker ct;

    public UndoCommandFactory(Stack commands, Stack redos, Caretaker ct){
        this.commands = commands;
        this.redos = redos;
        this.ct = ct;
    }

    public Command createCommand(){
        Command c = new UndoCommand(commands, redos, ct);
        return c ;
    }
    
}