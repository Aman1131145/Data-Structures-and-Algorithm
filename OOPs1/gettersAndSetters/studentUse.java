package OOPs1.gettersAndSetters;

public class studentUse {
    
    public static void main(String[] args) {
        student s1 = new student();
        student s2 = new student();

        s1.name = "Aman";
        s1.setRollNumber(23);
        s2.name = "Sourabh";
        s2.setRollNumber(12);

        System.out.println(s1.name);
        System.out.println(s2.getRollNumber());
    }
}
