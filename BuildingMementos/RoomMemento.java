package BuildingMementos;

import java.util.*;
import Buildings.*;
import CommandFactories.*;
import Commands.*;

public class RoomMemento{
    Building mBuilding;
    int mRoom_no;
    Room mRoom;
    double mLength;
    double mWidth;
    double newLength;
    double newWidth;
    //private int mRoom_no;
    

    public RoomMemento(Room room, Building building, int room_no,double length, double width){
        this.mBuilding = building;
        this.mRoom = room;
        this.mLength = room.getLength();
        this.mWidth = room.getWidth();
        this.mRoom_no = room_no;
        this.newLength = length;
        this.newWidth = width;
        //this.mRoom_no = index;
    }

    public Building getBuilding(){
        return this.mBuilding;
    }

    public int getRoomNo(){
        return this.mRoom_no;
    }

    public double getLength(){
        return this.newLength;
    }

    public double getWidth(){
        return this.newWidth;
    }

    public void restore(){
        mRoom.setLength(this.mLength);
        mRoom.setWidth(this.mWidth);
    }
}