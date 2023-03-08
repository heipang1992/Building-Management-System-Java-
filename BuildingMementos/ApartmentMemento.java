package BuildingMementos;

import java.util.*;
import Buildings.*;
import CommandFactories.*;
import Commands.*;

public class ApartmentMemento{
    Apartment mApartment;
    int id;
    ArrayList<Room> rooms;
    double monthlyRental;
    String supportStaff;
    String newName;
    double newRental;


    public ApartmentMemento(Apartment apartment, String name, double rental){
        this.mApartment = apartment;
        this.id = apartment.getId();
        this.rooms = apartment.getRooms();
        this.monthlyRental = apartment.getMonthlyRental();
        this.supportStaff = apartment.getSupportStaff();
        this.newName = name;
        this.newRental = rental;
    }
    public int getId(){
        return this.id;
    }

    public double getMonthlyRental(){
        return this.newRental;
    }

    public String getStaffName(){
        return newName;
    }

    public void restore(){
        mApartment.setSupportStaff(this.supportStaff);
        mApartment.setMonthlyRental(this.monthlyRental);
    }

    public void test(){
        System.out.println("Building id: " + this.id);
        System.out.println("Monthly Rental: " + this.monthlyRental);
        System.out.println("Support Staff: " + this.supportStaff);
    }
}