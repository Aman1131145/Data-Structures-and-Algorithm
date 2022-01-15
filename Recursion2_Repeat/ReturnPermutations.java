package Recursion2_Repeat;

import java.util.Scanner;

public class ReturnPermutations {

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = "abc";//s.nextLine();
		String output[] = ReturnPermutations.permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
        s.close();
	}
    
    public static String[] permutationOfStrings(String input) {

        if(input.length() <= 1){
            String[] ans = {input};
            return ans;
        }
        String ans[] = new String[input.length()];
        int k = 0;
        for(int i = 0; i <= input.length()+1; i++){
            ans[k] = input.substring(i, i+1) + permutationOfString(input.substring(0, i)+input.substring(i+1)); 
            k++;
        }
        return ans;
    }   
    public static String[] permutationOfString(String input){
        // Write your code here
        if(input.length() == 0){
            String y[] = {""};
            return y;
        }
    
        String [] ans = permutationOfString(input.substring(1));
        //  char ch = input.charAt(0);
        String output[] = new String[ans.length*input.length()];
    
        int k=0;
        for(int i=0;i<ans.length;i++){
        
            for(int j=0;j<=ans[i].length();j++){
                output[k++] = ans[i].substring(0,j) + input.charAt(0) + ans[i].substring(j);
            }
        }
        return output;
    }
}