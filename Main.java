import java.util.*;
import Commands.*;
import CommandFactories.*;
import Buildings.*;
import BuildingMementos.*;

public class Main{
    public static Scanner sc;
    public static void main(String[]args){
        
        // try{
        // File file = new File("command.txt");
        // sc = new Scanner(file);
        // }catch(Exception e){
        //     System.out.println("There is no command.txt");
        // }
        boolean isRunning = true;
        ArrayList<Building> building_list = new ArrayList<Building>();
        int target_building = 0;
        Stack commands = new Stack();
        Stack redos = new Stack();
        sc = new Scanner(System.in);
        

        Caretaker ct = new Caretaker();

        Command c;
        //AddApartmentCommandFactory aacf = new AddApartmentCommandFactory(sc, building_list,commands, redos, ct);
        //AddHouseCommandFactory ahcf = new AddHouseCommandFactory(sc, building_list, commands, redos, ct);

        // use a HashMap to store the command factories
        // <<<<< Create Command Factory ONCE ONLY >>>>>>>>>>> \\
        HashMap<String, CommandFactory> factory = new HashMap<>();

        
        factory.put("a", new AddBuildingCommandFactory(sc, building_list, commands, redos, ct));
        factory.put("d", new DisplayCommandFactory(sc, building_list));
        factory.put("m", new ModifyCommandFactory(sc, building_list, commands,ct));
        factory.put("e", new EditCommandFactory(sc, building_list, commands, redos,ct));
        factory.put("x", new ExitCommandFactory());
        factory.put("u", new UndoCommandFactory(commands, redos, ct));
        factory.put("r", new RedoCommandFactory(commands, redos, ct));
        factory.put("l", new ListCommandFactory(ct)); 

        

        while(true){
            String command;
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.println("Building Management System (BMS)");
            System.out.println("Please enter command: [a|d|m|e|u|r|l|x]");
            System.out.println("a = add building, d = display buildings, m = modify building, e = edit rooms");
            System.out.println("u = undo, r = redo, l = list undo/redo, x = exit system");

            
            command = sc.next();
            if( command.equals("a")||command.equals("d")||command.equals("m")||command.equals("e")||command.equals("u")||command.equals("r")||command.equals("l")||command.equals("x")){
                c = factory.get(command).createCommand();
                c.execute();
            }else{
                System.out.println("Please input valid command!!");
            }

        }
    }
}