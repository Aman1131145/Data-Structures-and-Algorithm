package Lists.ArrayList;

import java.util.*;

public class ArrayListDemo {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        System.out.println(list.size());
        list.add(10);
        list.add(17);
        list.add(15);
        list.add(1);

        list.add(2, 50);

        System.out.println(list.size());
        System.out.println(list.get(2));

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        list.remove(2);
        list.set(2, 45);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        
        System.out.println();
        for(int i : list){
            System.out.println(i + " ");
        }
    }
}
