package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;

public class DisplayCommand implements Command{
    private Scanner sc;
    private ArrayList<Building> building_list;

    public DisplayCommand(Scanner sc, ArrayList<Building> building_list){
        this.sc = sc;
        this.building_list = building_list;
    }


    public void execute(){
        // Display the buildings
        System.out.println("Enter Building No. (* to display all):");
        String building_no = sc.next();

        if (building_no.equals("*")){
            if (building_list.size() == 0){
                System.out.println("No Building Record was found in BMS ");
            }else{            
                for (int i=0;i<building_list.size();i++){
                System.out.println(building_list.get(i));
                }
            }
        }else{                
            for (int i=0;i<building_list.size();i++){
                if (building_list.get(i).getId() == Integer.parseInt(building_no)){
                    building_list.get(i).printBuilding();
                    break;
                }
            }
        }
    }

    public void undo(){

    }

    public void redo(){

    }
    
}
