package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;
public class ModifyRoomCommand implements Command{
    private int room_no;
    private ArrayList<Building> building_list;
    private Scanner sc;
    private Stack commands;
    private Stack redos;
    private Room rm;
    private int target_building;
    private double length;
    private double width;
    private double undo_length;
    private double undo_width;
    private Caretaker ct;


    public ModifyRoomCommand(Scanner sc,ArrayList<Building> building_list, Stack commands, Stack redos, int target_building, Caretaker ct){
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
        // Store the rm for undo
        Building building = building_list.get(target_building);
        rm = building.getRooms().get(room_no-1);
        undo_length = rm.getLength();
        undo_width = rm.getWidth();
        
        

        System.out.print("Length: ");
        length = sc.nextDouble();

        System.out.print("Width: ");
        width = sc.nextDouble();
        ct.saveRoom(rm, building,room_no,length,width);

        building_list.get(target_building).modifyRoom(room_no, length, width);
        
        System.out.println("Updated Building: ");
        building_list.get(target_building).printBuilding();
    }

    public void undo(){
    //     if(rm != null){
    //         // TEST // double rm_length = rm.getLength();
    //         // TEST //double rm_width = rm.getWidth();
    //         // TEST // System.out.println("Length is "+rm_length+" Width is "+ rm_width);
            
    //         System.out.println("Undo Length "+ undo_length+ "Undo_width "+ undo_width);
    //         building_list.get(target_building).modifyRoom(room_no, undo_length, undo_width);
    //     }
    // }
        ct.undo();
    }

    public void redo(){

        ///// ******** Wrong Index IN REDO ************ MUST FIX**********\\\\\\\
        if(rm != null){
            building_list.get(target_building).modifyRoom(room_no-1, length, width);
        }
    }



}