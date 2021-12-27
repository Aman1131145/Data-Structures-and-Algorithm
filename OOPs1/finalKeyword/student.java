package OOPs1.finalKeyword;

public class student {

    //final data members can be initalized as soon as they are declared
    private final int rollNumber;
    String name;

    public student(String n , int r){
        name = n ;
        rollNumber = r ; 
    }

    public void print(){
        System.out.println(name + " : " + rollNumber);
    }

}
