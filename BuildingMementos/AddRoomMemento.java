package BuildingMementos;

import java.util.*;
import Buildings.*;
import CommandFactories.*;
import Commands.*;

public class AddRoomMemento{
    Building mBuilding;
    int mRoom_no;
    Room mRoom;
    double mLength;
    double mWidth;
    // double newLength;
    // double newWidth;
    //private int mRoom_no;
    

    public AddRoomMemento(Room room, Building building, int room_no){
        this.mBuilding = building;
        this.mRoom = room;
        this.mLength = room.getLength();
        this.mWidth = room.getWidth();
        this.mRoom_no = room_no;
        // this.newLength = length;
        // this.newWidth = width;
        //this.mRoom_no = index;
    }

    public Building getBuilding(){
        return this.mBuilding;
    }
    
    public int getRoomNo(){
        return this.mRoom_no;
    }

    public double getLength(){
        return mLength;
    }

    public double getWidth(){
        return mWidth;
    }


    public void restore(){
        mBuilding.getRooms().remove(mRoom_no-1);
    }
}