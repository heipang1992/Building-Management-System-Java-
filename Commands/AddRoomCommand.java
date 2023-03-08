package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;
public class AddRoomCommand implements Command{
    Scanner sc;
    ArrayList<Building> building_list;
    Stack commands;
    Stack redos;
    int target_building;
    Room rm;
    Caretaker ct;
    

    public AddRoomCommand(Scanner sc, ArrayList<Building> building_list, Stack commands, Stack redos, int target_building, Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.commands = commands;
        this.redos = redos;
        this.target_building = target_building;
        this.rm = null;
        this.ct = ct;
    }

    public void execute(){
        System.out.print("Length: ");
        double length = sc.nextDouble();
        System.out.print("Width: ");
        double width = sc.nextDouble();
        
        Building building = building_list.get(target_building);
        rm = building_list.get(target_building).addRoom(length,width);

        ct.saveAddRoomMemento(rm, building, building.getRoomQty());
        System.out.println(rm);
        System.out.println("Updated Building:");
        building_list.get(target_building).printBuilding();
        // TEST : System.out.println("After rm");

    }

    public void undo(){
        // if ( rm != null){
        //     int roomNo = building_list.get(target_building).getRooms().size();
        //     building_list.get(target_building).deleteRoom(roomNo-1);
        // }
        ct.undo();
    }

    public void redo(){
        if ( rm != null){
            building_list.get(target_building).getRooms().add(rm);
        }
    }
}