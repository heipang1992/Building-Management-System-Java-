package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;

public class ListCommandFactory implements CommandFactory{

    private Caretaker ct;

    public ListCommandFactory(Caretaker ct){
        this.ct = ct;
    }

    public Command createCommand(){
        Command c = new ListCommand(ct);
        return c ;
    }
    
}