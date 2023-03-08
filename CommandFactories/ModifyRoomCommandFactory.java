package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;

public class ModifyRoomCommandFactory implements CommandFactory{
    private int room_no;
    private ArrayList<Building> building_list;
    private Scanner sc;
    private Stack commands;
    private Stack redos;
    private Room rm;
    private int target_building;
    private Caretaker ct;

    public ModifyRoomCommandFactory(Scanner sc, ArrayList<Building> building_list, Stack commands, Stack redos, int target_building, Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.commands = commands;
        this.redos = redos;
        this.target_building = target_building;
        this.ct = ct;
    }

    public Command createCommand(){
        Command c =  new ModifyRoomCommand(sc, building_list, commands, redos, target_building, ct);
        commands.push(c);
        redos.clear();
        return c ;
    }




}