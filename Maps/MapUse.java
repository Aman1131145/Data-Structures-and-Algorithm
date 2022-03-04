package Maps;
 
import java.util.*;

public class MapUse {

    public static void main(String[] args) {
        HashMap<String ,Integer> map = new HashMap<>();
    
        //insert
        map.put("abc", 1);
        map.put("def", 2);
        map.put("abc1", 1);
        map.put("def1", 2);

        System.out.println("size: " + map.size());
        // check Presence
        if (map.containsKey("abc")) {
            System.out.println("Has abc");
        }

        if(map.containsKey("abc1")){
            System.out.println("Has abc1");
        }

        if(map.containsValue(2)){
            System.out.println("has 2 as value");
        }

        // get value
        map.get("abc");
        if(map.containsKey("abc1")){
            map.get("abc1");
        }
        System.out.println("abc1");
        
        // remove
        int s = map.remove("abc");
        System.out.println(s);

        // itrate
        Set<String> keys = map.keySet();
        for(String str : keys){
            System.out.println(str);
        }
    }
}