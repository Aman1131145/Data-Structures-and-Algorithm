package Recursion2;

import java.util.Scanner;

public class SubSequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "xyz";//sc.next();
        String ans[] = SubSequences.subSequences(str);
        // ans = swap(ans);
        for(int i = 0; i <= ans.length-1; i++){
            System.out.println(ans[i] + " ");
        }
        sc.close();
    }

    private static String[] subSequences(String str) {
        /**BASE CASE
         * if str is empty then 
         * we will create an empty string array ans
         * then return it
         */
        if(str.isEmpty()){
            String ans[] = {""};
            return ans;
        }
        
        // here we are creating a string array smallAns calling the RECURSION by increasing the substring from 1
        String[] smallAns = subSequences(str.substring(1));
        // now we will create the String array ans having double the length of smallAns
        String[] ans = new String[smallAns.length*2];
        // Now we are calling a for loop that runs from the 0 index to the length of smallAns
        for(int i = 0; i < smallAns.length; i++){
            // here we are copying the character at the i index of smallAns to the i index of ans
            ans[i] = smallAns[i];
        }
        // here we are running the previous loop but with some changes
        for(int i = 0; i < smallAns.length; i++){
            // like copying the sum of character at zero index of str and character at i index of smallAns to i plus length of smallAns index of ans
            ans[i+smallAns.length] = str.charAt(0)+ smallAns[i];
        }
        // then we will return the ans
        return ans;
    }
    
}
