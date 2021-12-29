package OOPs2.inheritance;

public class Car extends Vehicle{
    int noOfGears;
    boolean isConvertable;

    public void print(){
        System.out.println("Car Color : " + color);
        System.out.println("Car Speed : " + getMaxSpeed());
        System.out.println("Car Number Of Gears : " + noOfGears);
        System.out.println("Car Is Convertable : " + isConvertable);
    }
}
