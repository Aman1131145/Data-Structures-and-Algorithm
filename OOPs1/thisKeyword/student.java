package OOPs1.thisKeyword;

public class student {

    //final data members can be initalized as soon as they are declared
    private final int rollNumber;
    String name;

    public student(String name , int rollNumber){
        this.name = name ;
        this.rollNumber = rollNumber ; 
    }

    public void print(){
        System.out.println(name + " : " + rollNumber);
    }

    
}
