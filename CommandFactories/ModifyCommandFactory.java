package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;

public class ModifyCommandFactory implements CommandFactory{
    private Scanner sc;
    private ArrayList<Building> building_list;
    private Stack commands;
    private Caretaker ct;

    public ModifyCommandFactory(Scanner sc, ArrayList<Building> building_list, Stack commands, Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.commands = commands;
        this.ct = ct;
    }


    public Command createCommand(){
        Command c = new ModifyCommand(sc, building_list, ct);
        commands.push(c);
        return c;
    }
}
