package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;


public class AddHouseCommandFactory implements CommandFactory{
    private Scanner sc;
    private ArrayList<Building> building_list;
    private Stack commands;
    private Stack redos;
    private Caretaker ct;

    public AddHouseCommandFactory(Scanner sc, ArrayList<Building> building_list, Stack commands, Stack redos,Caretaker ct){
        this.sc =sc;
        this.building_list = building_list;
        this.commands = commands;
        this.redos = redos;
        this.ct  = ct;
    }

    public Command createCommand(){
        Command c = new AddHouseCommand(sc, building_list, ct);
        commands.push(c);
        redos.clear();
        return c;
    }
    
}
