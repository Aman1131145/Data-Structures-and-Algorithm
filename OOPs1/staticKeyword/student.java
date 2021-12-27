package OOPs1.staticKeyword;

public class student {

    //final data members can be initalized as soon as they are declared
    private final int rollNumber;
    String name;

    private static int numStudents;

    public student(String name , int rollNumber){
        this.name = name ;
        this.rollNumber = rollNumber ; 

        numStudents++;
    }

    public static int getNumStudents(){
        return numStudents;
    }

    public void print(){
        System.out.println(name + " : " + rollNumber);
    }

    
}
