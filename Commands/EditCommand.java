package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;

public class EditCommand implements Command{
    private Scanner sc;
    private ArrayList<Building> building_list;
    private int target_building = 0;
    private Stack commands;
    private Stack redos;
    private Command c;
    private Caretaker ct;


    public EditCommand(Scanner sc, ArrayList<Building> building_list, Stack commands, Stack redos,Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.commands = commands;
        this.redos = redos;
        this.ct  = ct;
    }

    public void execute(){
        System.out.print("Building No.: ");
        int building_no = sc.nextInt();
        //Print the Building Details
        for (int i=0;i<building_list.size();i++){
            if (building_list.get(i).getId() == building_no){
                building_list.get(i).printBuilding();
                target_building = i;
                break;
            }
        }
        
        // Wait for next command on add/delete/modify room
        System.out.println();
        System.out.println("Please enter command: [a|d|m]");
        System.out.println("a = add room, d = delete room, m = modify room");
        String command_edit = sc.next();
        // Add a new room
        if (command_edit.equals("a")){
            AddRoomCommandFactory addRoomCommandFactory = new AddRoomCommandFactory(sc, building_list, commands, redos, target_building, ct);
            c = addRoomCommandFactory.createCommand();
            c.execute();
            // System.out.print("Length: ");
            // double length = sc.nextDouble();
            // System.out.print("Width: ");
            // double width = sc.nextDouble();

            // building_list.get(target_building).addRoom(length,width);
            
            // System.out.println("Updated Building:");
            // building_list.get(target_building).printBuilding();

        }else if (command_edit.equals("d")){
            // Delete a room
            DeleteRoomCommandFactory deleteRoomCommandFactory = new DeleteRoomCommandFactory(sc, building_list, commands, redos, target_building, ct);
            c = deleteRoomCommandFactory.createCommand();
            c.execute();

            // System.out.println("Room No.: ");
            // int room_no = sc.nextInt();

            // building_list.get(target_building).deleteRoom(room_no);
            // System.out.println("Updated Building: ");
            // building_list.get(target_building).printBuilding();

        }else if (command_edit.equals("m")){
            // Modify a room
            ModifyRoomCommandFactory modifyRoomCommandFactory = new ModifyRoomCommandFactory(sc, building_list, commands, redos, target_building, ct);
            c = modifyRoomCommandFactory.createCommand();
            c.execute();
            // System.out.println("Room No.: ");
            // int room_no = sc.nextInt();
            // System.out.print("Length: ");
            // double length = sc.nextDouble();

            // System.out.print("Width: ");
            // double width = sc.nextDouble();

            // building_list.get(target_building).modifyRoom(room_no, length, width);
            
            // System.out.println("Updated Building: ");
            // building_list.get(target_building).printBuilding();
        }
    }

    public void undo(){

    }

    public void redo(){

    }
}
