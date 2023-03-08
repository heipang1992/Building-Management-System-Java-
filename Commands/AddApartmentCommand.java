package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;


public class AddApartmentCommand implements Command{
    Scanner sc;
    ArrayList<Building> building_list;
    Building building1;
    Caretaker ct;


    public AddApartmentCommand(Scanner sc, ArrayList<Building> building_list, Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.building1 = null;
        this.ct = ct;
    }

    public void execute(){

        try{
        System.out.print("Building No.: ");
        int building_no = sc.nextInt();

        // Consuming the leftover new line
        // using the nextLine() method
        sc.nextLine();
        System.out.print("Monthly Rental: ");
        double monthly_rental = Double.parseDouble(sc.nextLine());

        System.out.print("Support Staff: ");
        String support_staff = sc.nextLine();
        
        System.out.print("Number of rooms: ");
        int no_of_rooms = sc.nextInt();

        // Create an Apartment 
        // Put the Apartment into the Building Arraylsit
        building1 = new Apartment(building_no, no_of_rooms, monthly_rental, support_staff);
        building_list.add(building1);

        //for loop to addRoom 
        for(int i=1;i<=no_of_rooms;i++){
            System.out.println("Room No. " + i + " :");
            System.out.print("Length: ");
            double room_length = sc.nextDouble();
            System.out.print("Width: ");
            double room_width = sc.nextDouble();
            building1.addRoom(room_length, room_width);
        }
        System.out.println("New Building Added: ");
        building1.printBuilding();


        // Maybe can cancel
        ct.saveAddApartment((Apartment)building1);
        }catch(Exception e){
            System.out.println("******* AddApartmentCommand is ERROR **************");
        }
    }

    public void undo(){
        if(building1 != null){
            building_list.remove(building1);
        }
    }

    public void redo(){
        if(building1 != null){
            building_list.add(building1);
        }

    }
}