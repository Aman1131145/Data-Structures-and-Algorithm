package Recursion2_Repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PrintPermutaitons
 */
public class PrintPermutaitons {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        PrintPermutaitons.FindPermutations(str);
    }

    public static void FindPermutations(String str) {
        findPermutations(str,"");
    }

    public static void findPermutations(String input,String output){
        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        
        for(int i=0;i<input.length();i++){
            String str = input.substring(0,i) + input.substring(i+1,input.length());    
            findPermutations(str , output + input.charAt(i));
        }
        
        // input = input.substring(1);
        // print(input,output);
        
        
    }
}