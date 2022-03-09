package Maps;

import java.io.*;
import java.util.*;

public class UniqueCharacter {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String takeInput() throws IOException {
        String str = br.readLine(); 
        return str;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(UniqueCharacter.uniqueChar(str));


    }

    public static String uniqueChar(String str){
        String x="";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++) {
            if(!map.containsKey(str.charAt(i))) {
                x+=str.charAt(i);
                map.put(str.charAt(i),1);
            }
        }
        return x;
    }
    
}
