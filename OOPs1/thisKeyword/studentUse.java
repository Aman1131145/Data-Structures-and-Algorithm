package OOPs1.thisKeyword;

public class studentUse {
    
    public static void main(String[] args) {
        student s1 = new student("Aman",1);
        student s2 = new student("Sourabh",2);
        
        System.out.println(s1);
        s1.print();
        s2.print();

        System.out.println(s1.name);
    }
    
    
}
