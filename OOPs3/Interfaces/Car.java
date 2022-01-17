package OOPs3.Interfaces;

public class Car extends Vehicle implements CarInterface {
    @Override
    public void print() {
        super.print();
    }

    @Override
    public int getMaxSpeed() {
        return super.getMaxSpeed();
    }
    
    @Override
    public String getCompany() {
        return null;
    }
}
