package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;

public class DeleteRoomCommand implements Command{
    private int room_no;
    private ArrayList<Building> building_list;
    private Scanner sc;
    private Stack commands;
    private Stack redos;
    private Room rm;
    private int target_building;
    private Caretaker ct;


    public DeleteRoomCommand(Scanner sc,ArrayList<Building> building_list, Stack commands, Stack redos, int target_building, Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.commands = commands;
        this.redos = redos;
        this.target_building = target_building;
        this.ct = ct;
    }

    public void execute(){
        System.out.println("Room No.: ");
        room_no = sc.nextInt();
        Building building = building_list.get(target_building);
        rm = building_list.get(target_building).deleteRoom(room_no);
        ct.saveDeleteRoomMemento(rm, building, room_no);
        System.out.println("Updated Building: ");
        building_list.get(target_building).printBuilding();
    }

    public void undo(){
            ct.undo();
            // TEST // double rm_length = rm.getLength();
            // TEST //double rm_width = rm.getWidth();
            // TEST // System.out.println("Length is "+rm_length+" Width is "+ rm_width);
            //building_list.get(target_building).getRooms().add(room_no-1,rm);
        
    }

    public void redo(){
        if(rm != null){
            building_list.get(target_building).deleteRoom(room_no);
        }
    }



}