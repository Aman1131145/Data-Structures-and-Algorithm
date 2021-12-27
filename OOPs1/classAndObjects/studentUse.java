package OOPs1.classAndObjects;


public class studentUse {

    public static void main(String[] args) {
        student s1 = new student();
        student s2 = new student();

        s1.name = "Aman";
        s2.name = "Sourabh";

        s1.rollNumber = 1;
        s2.rollNumber = 2;

        System.out.println(s1.name);
        System.out.println(s2.rollNumber);
        System.out.println(s1);

    }
    
}
