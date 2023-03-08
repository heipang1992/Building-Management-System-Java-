package Buildings;

import java.util.*;


public class House extends Building{
    private int noOfFloors;

    public House(int id, int noOfRooms, int noOfFloors){
        super(id,noOfRooms);
        this.noOfFloors = noOfFloors;
    }

    public void setFloors(int noOfFloors){
        this.noOfFloors = noOfFloors;
    }

    public int getFloors(){
        return noOfFloors;
    }

    public void modifyBuilding(){
        // Wait for Adding
    }

    public void printBuilding(){
        System.out.println("Building No: " + super.getId());
        System.out.println("No of Floors: " + getFloors());
        ArrayList<Room> rooms = super.getRooms();
        for (int i = 1; i<=rooms.size();i++){
            System.out.println("Room No.: " + i + ", Length: " + rooms.get(i-1).getLength() 
            + ", Width: " + rooms.get(i-1).getWidth());
        }
    }

    public String toString(){
        // Wait for Adding
        String wordings = "Building No.: "+ super.getId() + ", No. of Floors: " + getFloors() ;
        return wordings;
    }

}
    
