package Buildings;

import java.util.*;


public class Apartment extends Building{
    private double monthlyRental;
    private String supportStaff;

    public Apartment(int id, int noOfRooms, double monthlyRental, String supportStaff){
        super(id,noOfRooms);
        this.monthlyRental = monthlyRental;
        this.supportStaff = supportStaff;
    }

    public void setMonthlyRental(double monthlyRental){
        this.monthlyRental = monthlyRental;
    }

    public double getMonthlyRental(){
        return monthlyRental;
    }

    public void setSupportStaff(String supportStaff){
        this.supportStaff = supportStaff;
    }

    public String getSupportStaff(){
        return supportStaff;
    }

    public void modifyBuilding(){
        
    }

    public void printBuilding(){
        System.out.println("Building No: " + super.getId());
        System.out.println("Support Staff: " + getSupportStaff());
        System.out.println("Monthly Rental: " + getMonthlyRental());
        ArrayList<Room> rooms = super.getRooms();
        for (int i = 1; i<=rooms.size();i++){
            System.out.println("Room No.: " + i + ", Length: " + rooms.get(i-1).getLength() 
            + ", Width: " + rooms.get(i-1).getWidth());
        }
        
    }

    public String toString(){
        // Wait to ADD
        String wordings = "Building No.: "+ super.getId() + ", Support Staff: " + getSupportStaff() + ", Monthly Rental: "+ getMonthlyRental();
        return wordings;
    }


}
    
