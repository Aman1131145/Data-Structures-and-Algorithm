package Maps;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int a[] = {1,3,2,1,2,2,2,10000,3,2};
        ArrayList<Integer> output = removeDuplicates(a);
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }

    public static ArrayList<Integer> removeDuplicates(int a[]){
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer,Boolean> seen = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(seen.containsKey(a[i])){
                continue;
            }
            output.add(a[i]);
            seen.put(a[i], true);
        }
        return output;
    }
    
}
