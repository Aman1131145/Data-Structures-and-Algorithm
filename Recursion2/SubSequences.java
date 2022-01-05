package Recursion2;

import java.util.Scanner;

public class SubSequences {

    private static String[] swap(String[] ans){
        int length = 1;
        int index = 0;
        
        for(int i = 0; i <= ans.length-1; i++){
            for(int j = 0; j <= ans.length; j++){
                if(ans[i].length() == length){
                    String temp = ans[i];
                    ans[index] = ans[i];
                    ans[i] = temp;
                    index = index + 1;
                }
            }
            length = length+1;
        }
        return ans ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "xyz";//sc.next();
        String ans[] = SubSequences.subSequences(str);
        ans = swap(ans);
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
