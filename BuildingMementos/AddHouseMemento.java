package BuildingMementos;

import java.util.*;
import Buildings.*;
import CommandFactories.*;
import Commands.*;

public class AddHouseMemento{
    House mHouse;
    int id;
    ArrayList<Room> rooms;
    int no_floors;

    public AddHouseMemento(House house){
        this.mHouse = house;
        this.id = house.getId();
        this.rooms = house.getRooms();
        this.no_floors = house.getFloors();
    }

    public int getId(){
        return this.id;
    }

    public int getFloors(){
        return this.no_floors;
    }

    public void restore(){
        mHouse.setFloors(this.no_floors);
    }

    public void test(){
        System.out.println("Building id: " + this.id);
        System.out.println("No of Floors: " + this.no_floors);
    }
}