package OOPs2.inheritance;

public class VehicleUse {
        
    public static void main(String[] args) {
        
        Vehicle v = new Vehicle();
        v.print();

        Car c = new Car();
        c.noOfGears = 10;
        c.color = "Black";
        c.setMaxSpeed(100);
        c.print();

    }
}


