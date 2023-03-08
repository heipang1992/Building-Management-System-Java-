package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;

public class ListCommand implements Command{
    private Caretaker ct;

    public ListCommand(Caretaker ct){
        this.ct = ct;
    }   

    public void execute(){
        // get the command c going to be undo
        // call c.undo();
        Stack undo_list = ct.getUndoStack();
        int undo_size = undo_list.size();

        Stack redo_list = ct.getRedoStack();
        int redo_size = redo_list.size();

        // Print the Undo List
        if(undo_size>0){
            System.out.println("Undo List: ");
            for(int i = undo_size-1;i>=0;i--){
                Object abc = undo_list.get(i);
                if(abc instanceof ApartmentMemento){
                    ApartmentMemento obj = (ApartmentMemento)abc;
                    System.out.println("Modify Building No. "+ obj.getId() + ", Support Staff: " + obj.getStaffName()+ ", Monthly Rental: " + obj.getMonthlyRental());
                }else if (abc instanceof HouseMemento){
                    HouseMemento obj = (HouseMemento)abc;
                    System.out.println("Modify Building No. " + obj.getId() + ", No. of Floor: " + obj.getFloors());
                }else if (abc instanceof RoomMemento){
                    RoomMemento obj = (RoomMemento)abc;
                    System.out.println("Modify Room: Building No. " + obj.getBuilding().getId() + ", Room No. " + obj.getRoomNo() + ", Length: "+ obj.getLength() + ", Width: " + obj.getWidth());
                }else if (abc instanceof AddApartmentMemento){
                    AddApartmentMemento obj = (AddApartmentMemento)abc;
                    System.out.println("Add Building: Building No.: "+ obj.getId()+ ", Support Staff: "+ obj.getStaff() + ", Monthly Rental: "+ obj.getMonthlyRental());
                }else if (abc instanceof AddHouseMemento){
                    AddHouseMemento obj = (AddHouseMemento)abc;
                    System.out.println("Add Building: Building No.: "+obj.getId() + ", No. of Floor: " + obj.getFloors());
                }else if (abc instanceof AddRoomMemento){
                    AddRoomMemento obj = (AddRoomMemento)abc;
                    System.out.println("Add Room: Building No. "+obj.getBuilding().getId()+", Room No. "+ obj.getRoomNo() +", Length: "+obj.getLength()+", Width: "+obj.getWidth());
                }else if (abc instanceof DeleteRoomMemento){
                    DeleteRoomMemento obj = (DeleteRoomMemento)abc;
                    System.out.println("Delete Room: Building No. "+obj.getBuilding().getId()+", Room No. "+ obj.getRoomNo()+", Length: "+obj.getLength()+", Width: "+obj.getWidth());
                }
            }    
        }else{
            System.out.println("The Stack is Empty! Nothing to undo!");
        }

        // Print the Redo List 
        if(redo_size>0){
            System.out.println();
            System.out.println("Redo List: ");
            for(int i = redo_size-1;i>=0;i--){
                Object abc = redo_list.get(i);
                if(abc instanceof ApartmentMemento){
                    ApartmentMemento obj = (ApartmentMemento)abc;
                    System.out.println("Modify Building No. "+ obj.getId() + ", Support Staff: " + obj.getStaffName()+ ", Monthly Rental: " + obj.getMonthlyRental());
                }else if (abc instanceof HouseMemento){
                    HouseMemento obj = (HouseMemento)abc;
                    System.out.println("Modify Building No. " + obj.getId()+ ", No. of Floor: " + obj.getFloors());
                }else if (abc instanceof RoomMemento){
                    RoomMemento obj = (RoomMemento)abc;
                    System.out.println("Modify Room: Building No. " + obj.getBuilding().getId() + ", Room No. " + obj.getRoomNo() + ", Length: "+ obj.getLength() + ", Width: " + obj.getWidth());
                }else if (abc instanceof AddApartmentMemento){
                    AddApartmentMemento obj = (AddApartmentMemento)abc;
                    System.out.println("Add Building: Building No.: "+ obj.getId()+ ", Support Staff: "+ obj.getStaff() + ", Monthly Rental: "+ obj.getMonthlyRental());
                }else if (abc instanceof AddHouseMemento){
                    AddHouseMemento obj = (AddHouseMemento)abc;
                    System.out.println("Add Building: Building No.: "+obj.getId() + ", No. of Floor: " + obj.getFloors());
                }else if (abc instanceof AddRoomMemento){
                    AddRoomMemento obj = (AddRoomMemento)abc;
                    System.out.println("Add Room: Building No. "+obj.getBuilding().getId()+", Room No. "+ obj.getRoomNo() +", Length: "+obj.getLength()+", Width: "+obj.getWidth());
                }else if (abc instanceof DeleteRoomMemento){
                    DeleteRoomMemento obj = (DeleteRoomMemento)abc;
                    System.out.println("Delete Room: Building No. "+obj.getBuilding().getId()+", Room No. "+ obj.getRoomNo()+", Length: "+obj.getLength()+", Width: "+obj.getWidth());
                }
            }
        }else{
            System.out.println();
            System.out.println("Redo List:");
            System.out.println("Nothing to Redo.");
        }

    }

    public void undo(){
        //nothing
    }
    
    public void redo(){
        //nothing
    }
}
