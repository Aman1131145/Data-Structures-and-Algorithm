package OOPs3.Generics;

import OOPs3.Interfaces.Vehicle;

public class Print {

    public static<T extends PrintInterface > void printArray(T a[]){
        for(int i = 0; i < a.length; i++){ 
            a[i].print();
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Integer a[] = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i+1;
        }
        String b[] = new String[10];
        for (int i = 0; i < 10; i++) {
            b[i] = "a";
        }

        // printArray(b);
        // printArray(a);

        Vehicle v[] = new Vehicle[10];
        for (int i = 0; i < 10; i++) {
            v[i] = new Vehicle();
        }
        // printArray(v);
    }
}
