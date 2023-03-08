package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;

public class AddBuildingCommand implements Command{
    Scanner sc;
    ArrayList<Building> building_list;
    CommandFactory cf;
    Command c;
    Stack commands;
    Stack redos;
    Caretaker ct;

    public AddBuildingCommand(Scanner sc, ArrayList<Building> building_list, Stack commands, Stack redos, Caretaker ct){
        this.sc = sc;
        this.building_list = building_list;
        this.commands = commands;
        this.redos = redos;
        this.ct = ct;
    }

    public void execute(){

        try{
        System.out.println("Enter Building Type (a=Apartment/h=House):");
        String command = sc.next();
        if (command.equals("a")){
            cf = new AddApartmentCommandFactory(sc, building_list, commands,redos,ct);
            c = cf.createCommand();
            c.execute();
        }else if (command.equals("h")){
            cf = new AddHouseCommandFactory(sc,building_list, commands,redos,ct);
            c = cf.createCommand();
            c.execute();
        }
        }catch(Exception e){
            System.out.println("***********    AddBuildingCommand is ERROR  ************");
        }
    }

    public void undo(){

    }

    public void redo(){

    }
}
