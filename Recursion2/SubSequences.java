package Recursion2;

import java.util.Scanner;

public class SubSequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "xyz";//sc.next();
        String ans[] = SubSequences.subSequences(str);
        // ans = swap(ans);
        for(int i = 0; i <= ans.length-1; i++){
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }

    private static String[] subSequences(String str) {
        if(str.isEmpty()){
            String ans[] = {""};
            return ans;
        }
        
        String[] smallAns = subSequences(str.substring(1));
        String[] ans = new String[smallAns.length*2];
        for(int i = 0; i < smallAns.length; i++){
            ans[i] = smallAns[i];
        }
        for(int i = 0; i < smallAns.length; i++){
            ans[i+smallAns.length] = str.charAt(0)+ smallAns[i];
        }
        
        return ans;
    }
    
}
