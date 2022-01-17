package OOPs3;

public abstract class Car extends Vehicle{
    int noOfGears;
    boolean isConvertable;

    public Car(int noOfGears, int maxSpeed){
        super(maxSpeed);
        this.noOfGears = noOfGears;
        System.out.println("Car Constructor");
    }

    public Car(){
        super(100);
    }

    @Override
    public boolean isMotarized() {
        return true;
    }

    public void print(){
        super.print();
        System.out.println("Car Number Of Gears : " + noOfGears);
        System.out.println("Car Is Convertable : " + isConvertable);
    }
}
