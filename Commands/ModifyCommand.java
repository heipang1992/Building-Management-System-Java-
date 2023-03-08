package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;



public class ModifyCommand implements Command{
    private Scanner sc;
    private ArrayList<Building> building_list;
    private int target_building = 0;
    private Caretaker ct;


    public ModifyCommand(Scanner sc, ArrayList<Building> building_list, Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.ct = ct;
    }
    
    public void execute(){
        System.out.print("Building No.: ");
        int building_no = sc.nextInt();

        //Print the Building Details
        for (int i=0;i<building_list.size();i++){
            
            if (building_list.get(i).getId() == building_no){
                System.out.println(building_list.get(i));
                target_building = i;
                break;
            }
        }


        // Clarify the Type of Building
        Class clazz = building_list.get(target_building).getClass();
        //System.out.println(clazz);
        Building b = building_list.get(target_building);
        if(b instanceof Apartment){
        //Modify Building Details
            //System.out.println("YES! I am Apartment!");
            System.out.print("Modify Monthly Rental: ");
            double monthly_rental = sc.nextDouble();
            Apartment a  = Apartment.class.cast(b);
            //a.setMonthlyRental(monthly_rental);

            sc.nextLine();
            System.out.print("Modify Support Staff: ");
            String support_staff  = sc.nextLine();
            //a.setSupportStaff(support_staff);
            
            ct.saveApartment(a,support_staff,monthly_rental);
            a.setMonthlyRental(monthly_rental);
            a.setSupportStaff(support_staff);
            // Print out the modified data
            System.out.println("Building is modified:");
            System.out.println(a);
        }else{
            //System.out.println("YES! I am House!");
            System.out.print("No. of Floors: ");
            int no_of_floors = sc.nextInt();
            House h  = House.class.cast(b);

            // Caretaker Take the shot of House
            // Then modify the no of floor of the house
            ct.saveHouse(h, no_of_floors);
            h.setFloors(no_of_floors);

            // Print out the modified data
            System.out.println("Building is modified:");
            System.out.println(h);

        }
    }

    public void undo(){
        ct.undo();
    }

    public void redo(){

    }
    
}
