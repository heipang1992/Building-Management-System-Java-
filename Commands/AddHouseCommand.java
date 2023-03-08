package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;


public class AddHouseCommand implements Command{
    Scanner sc;
    ArrayList<Building> building_list;
    Building building2;
    Caretaker ct;

    public AddHouseCommand(Scanner sc, ArrayList<Building> building_list, Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.building2 = null;
        this.ct = ct;
    }

    public void execute(){

        try{
        System.out.print("Building No.: ");
        int building_no = sc.nextInt();

        System.out.print("No. of Floors: ");
        int no_of_floors = sc.nextInt();

        System.out.print("Number of rooms: ");
        int no_of_rooms = sc.nextInt();

        //Create an House
        // Put the House into the Building Arraylsit
        building2 = new House(building_no, no_of_rooms, no_of_floors);
        building_list.add(building2);

        //for loop to addRoom 
        for(int i=1;i<=no_of_rooms;i++){
            System.out.println("Room No. " + i + " :");
            System.out.print("Length: ");
            double room_length = sc.nextDouble();
            System.out.print("Width: ");
            double room_width = sc.nextDouble();
            building2.addRoom(room_length, room_width);
        }

        ct.saveAddHouse((House)building2);

        System.out.println("New Building Added: ");
        building2.printBuilding();
        }catch(Exception e){
            System.out.println("********AddHouseCommand is ERROR *********");
        }
    }

    public void undo(){
        if(building2 != null){
            building_list.remove(building2);
        }
    }

    public void redo(){
        if(building2 != null){
            building_list.add(building2);
        }
    }



}
