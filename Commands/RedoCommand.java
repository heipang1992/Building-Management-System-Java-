package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;

public class RedoCommand implements Command{
    private Stack redos;
    private Stack commands;
    private Caretaker ct;

    private Stack undo_list;
    private Stack redo_list;

    public RedoCommand(Stack commands, Stack redos, Caretaker ct){
        this.redos = redos;
        this.commands = commands;
        this.ct = ct;
        undo_list = ct.getUndoStack();
        redo_list = ct.getRedoStack();
    }


    public void execute(){
        // pop the undo ed command
        // push the command c into the Stack commands
        if (redo_list.size()>0){
            ct.redo();
        }else{
            System.out.println("Nothing to redo! "); 
        }
    }

    public void undo(){

    }

    public void redo(){

    }
}
