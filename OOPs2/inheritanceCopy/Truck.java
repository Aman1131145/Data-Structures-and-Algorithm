package OOPs2.inheritanceCopy;

import OOPs2.inheritance.Vehicle;

public class Truck extends Vehicle{
    public Truck(int maxSpeed) {
        super(maxSpeed);
    }

    int maxLoadingCapacity;

    public void print(){
        System.out.println("Truck capacity : " + maxLoadingCapacity);
        System.out.println("Truck color : " + color);
        System.out.println("Truck speed : " + getMaxSpeed());
    }
}
