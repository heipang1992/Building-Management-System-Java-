package Buildings;

import java.util.*;


public abstract class Building{
    private int id;
    private ArrayList<Room> rooms;

    public Building(int id, int noOfRooms){
        this.id = id;
        rooms = new ArrayList<Room>();
    }
    

    public int getId(){
        return id;
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    public Room addRoom(double length, double width){
        Room rm = new Room(length,width);
        rooms.add(rm);
        return rm;
    }

    public void modifyRoom(int roomNo, double length, double width){
        rooms.get(roomNo-1).setLength(length);
        rooms.get(roomNo-1).setWidth(width);
    }

    public Room deleteRoom(int roomNo){
        return rooms.remove(roomNo-1);
    }

    public void printRooms(){
        // Print the rooms
    }

    public int getRoomQty(){
        
        return rooms.size();
        // Return the Quantity of Room
    }

    public abstract void modifyBuilding();

    public abstract void printBuilding();

}