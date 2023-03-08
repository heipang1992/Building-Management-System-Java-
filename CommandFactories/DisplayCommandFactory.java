package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;


public class DisplayCommandFactory implements CommandFactory{
    private Scanner sc;
    private ArrayList<Building> building_list;

    public DisplayCommandFactory(Scanner sc, ArrayList<Building> building_list){
        this.sc = sc;
        this.building_list = building_list;
    }

    public Command createCommand(){
        Command c = new DisplayCommand(sc, building_list);
        return c;
    }


    
}
