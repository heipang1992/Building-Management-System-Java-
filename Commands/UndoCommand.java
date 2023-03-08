package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;

public class UndoCommand implements Command{
    private Stack commands;
    private Stack redos;
    private Caretaker ct;

    private Stack undo_list;
    private Stack redo_list;

    public UndoCommand(Stack commands, Stack redos, Caretaker ct){
        this.commands = commands;
        this.redos = redos;
        this.ct = ct;
        undo_list = ct.getUndoStack();
        redo_list = ct.getRedoStack();
    }   

    public void execute(){
        // get the command c going to be undo
        // call c.undo();

        // if(!commands.isEmpty()){
        //     Command c = (Command) commands.pop();
        //     c.undo();
        //     redos.push(c); 
        if(undo_list.size()>0){
            ct.undo();   
        }else{
            System.out.println("The Stack is Empty! Nothing to undo!");
        }
    }

    public void undo(){

    }
    
    public void redo(){

    }
}
