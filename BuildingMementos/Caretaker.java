package BuildingMementos;

import java.util.*;
import Buildings.*;
import CommandFactories.*;
import Commands.*;

public class Caretaker {

    private Stack snap_undoList;
    private Stack snap_redoList;

    public Caretaker(){
        snap_undoList = new Stack();
        snap_redoList = new Stack();
    }

    public void saveApartment(Apartment apartment, String name, Double rental){
        ApartmentMemento am = new ApartmentMemento(apartment, name, rental);
        snap_undoList.push(am);
    }

    public void saveAddApartment(Apartment apartment){
        AddApartmentMemento aam = new AddApartmentMemento(apartment);
        snap_undoList.push(aam);
    }

    public void saveHouse(House house, int floors){
        HouseMemento hm = new HouseMemento(house, floors);
        snap_undoList.push(hm);
    }

    public void saveAddHouse(House house){
        AddHouseMemento ahm = new AddHouseMemento(house);
        snap_undoList.push(ahm);
    }

    public void saveRoom(Room room, Building building, int room_no,double length, double width){
        RoomMemento rm = new RoomMemento(room, building,room_no,length,width);
        snap_undoList.push(rm);
    }

    public void saveAddRoomMemento(Room room, Building building, int room_no){
        AddRoomMemento addRoom = new AddRoomMemento(room, building, room_no);
        snap_undoList.push(addRoom);
    }

    public void saveDeleteRoomMemento(Room room, Building building, int room_no){
        DeleteRoomMemento deleteRoom = new DeleteRoomMemento(room, building, room_no);
        snap_undoList.push(deleteRoom);
    }

    public void undo(){
        if(snap_undoList.size()>0){
            Object obj = snap_undoList.pop();
            
            if(obj instanceof ApartmentMemento){
                ApartmentMemento am = (ApartmentMemento) obj;
                snap_redoList.push(new ApartmentMemento(am.mApartment, am.supportStaff, am.newRental));
                am.restore();
                //snap_undoList.remove(obj);
                //System.out.println(" I am doing Modify Apartment Caretaker Undo !!!!!!!!!!");
            }else if(obj instanceof HouseMemento){
                HouseMemento hm = (HouseMemento) obj;
                snap_redoList.push(new HouseMemento(hm.mHouse, hm.newFloors));
                hm.restore();
            }else if (obj instanceof RoomMemento){
                RoomMemento rm = (RoomMemento) obj;
                snap_redoList.push(new RoomMemento(rm.mRoom, rm.mBuilding, rm.mRoom_no, rm.newLength, rm.newWidth));
                rm.restore();
                //System.out.println(" I am doing Modify Room Caretaker Undo !!!!!!!!!!");
            }else if (obj instanceof AddApartmentMemento){
                AddApartmentMemento rm = (AddApartmentMemento) obj;
                snap_redoList.push(new AddApartmentMemento(rm.mApartment));
                rm.restore();
            }else if (obj instanceof AddHouseMemento){
                AddHouseMemento rm = (AddHouseMemento) obj;
                snap_redoList.push(new AddHouseMemento(rm.mHouse));
                rm.restore();
            }else if(obj instanceof DeleteRoomMemento){
                DeleteRoomMemento rm = (DeleteRoomMemento) obj;
                snap_redoList.push(new DeleteRoomMemento(rm.mRoom, rm.mBuilding, rm.mRoom_no));
                rm.restore();
                //System.out.println(" I am doing Delete Room Caretaker Undo !!!!!!!!!!");
            }else if(obj instanceof AddRoomMemento){
                AddRoomMemento rm = (AddRoomMemento) obj;
                snap_redoList.push(new AddRoomMemento(rm.mRoom, rm.mBuilding, rm.mRoom_no));
                rm.restore();
                //System.out.println(" I am doing Add Room Caretaker Undo !!!!!!!!!!");
            }
        }
    }


    public void redo(){
        if(snap_redoList.size()>0){
            Object obj = snap_redoList.pop();
            
            if(obj instanceof ApartmentMemento){
                ApartmentMemento am = (ApartmentMemento) obj;
                snap_undoList.push(new ApartmentMemento(am.mApartment, am.supportStaff, am.newRental));
                //am.restore();
                //snap_undoList.remove(obj);
                //System.out.println(" I am doing Modify Apartment Caretaker Undo !!!!!!!!!!");
            }else if(obj instanceof HouseMemento){
                HouseMemento hm = (HouseMemento) obj;
                snap_undoList.push(new HouseMemento(hm.mHouse, hm.newFloors));
                //hm.restore();
            }else if (obj instanceof RoomMemento){
                RoomMemento rm = (RoomMemento) obj;
                snap_undoList.push(new RoomMemento(rm.mRoom, rm.mBuilding, rm.mRoom_no, rm.newLength, rm.newWidth));
                rm.restore();
                //System.out.println(" I am doing Modify Room Caretaker Undo !!!!!!!!!!");
            }else if (obj instanceof AddApartmentMemento){
                AddApartmentMemento rm = (AddApartmentMemento) obj;
                snap_undoList.push(new AddApartmentMemento(rm.mApartment));
                //rm.restore();
            }else if (obj instanceof AddHouseMemento){
                AddHouseMemento rm = (AddHouseMemento) obj;
                snap_undoList.push(new AddHouseMemento(rm.mHouse));
                //rm.restore();
            }else if(obj instanceof DeleteRoomMemento){
                DeleteRoomMemento rm = (DeleteRoomMemento) obj;
                snap_undoList.push(new DeleteRoomMemento(rm.mRoom, rm.mBuilding, rm.mRoom_no));
                //rm.restore();
                //System.out.println(" I am doing Delete Room Caretaker Undo !!!!!!!!!!");
            }else if(obj instanceof AddRoomMemento){
                AddRoomMemento rm = (AddRoomMemento) obj;
                snap_undoList.push(new AddRoomMemento(rm.mRoom, rm.mBuilding, rm.mRoom_no));
                rm.mBuilding.getRooms().add(rm.mRoom_no-1, rm.mRoom);//rm.restore();
                //System.out.println(" I am doing Add Room Caretaker Undo !!!!!!!!!!");
            }
        }else{
            System.out.println("Nothing for Caretaker to Redo");
        }
            
    }

    public Stack getUndoStack(){
        return this.snap_undoList;
    }

    public Stack getRedoStack(){
        return this.snap_redoList;
    }
}
