package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;

public class AddRoomCommandFactory implements CommandFactory{
    private Scanner sc;
    private ArrayList<Building> building_list;
    private Stack commands;
    private Stack redos;
    private int target_building;
    private Caretaker ct;

    public AddRoomCommandFactory(Scanner sc, ArrayList<Building> building_list, Stack commands, Stack redos, int target_building, Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.commands = commands;
        this.redos = redos;
        this.target_building = target_building;
        this.ct  = ct;
    }

    public Command createCommand(){
        Command c = new AddRoomCommand(sc, building_list, commands, redos, target_building, ct);
        commands.push(c);
        redos.clear();
        return c;
    }

}