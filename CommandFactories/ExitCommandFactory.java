package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;

public class ExitCommandFactory implements CommandFactory{

    public Command createCommand(){
        Command c = new ExitCommand();
        return c;
    }
}