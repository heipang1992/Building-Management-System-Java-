package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;

public class ExitCommand implements Command{

    public void execute(){
        System.exit(0);
    }

    public void undo(){

    }

    public void redo(){

    }
    
}
