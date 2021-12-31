package OOPs2.inheritance;

public class Car extends Vehicle{
    int noOfGears;
    boolean isConvertable;

    public Car(int noOfGears, int maxSpeed){
        super(maxSpeed);
        this.noOfGears = noOfGears;
        System.out.println("Car Constructor");
    }

    public void print(){
        super.print();
        System.out.println("Car Number Of Gears : " + noOfGears);
        System.out.println("Car Is Convertable : " + isConvertable);
    }
}
