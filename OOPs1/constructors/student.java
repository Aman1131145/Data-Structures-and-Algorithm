package OOPs1.constructors;

public class student {

    
    private int rollNumber;
    String name;

    public student(String n , int r){
        name = n ;
        rollNumber = r ; 
    }

    public void print(){
        System.out.println(name + " : " + rollNumber);
    }

    public void setRollNumber(int rn){
        rollNumber = rn;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    
}
