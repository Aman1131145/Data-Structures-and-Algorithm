package Recursion;

import java.util.Scanner;

public class ReplacePi {
    
    static String ans;
    // Return the changed string
	public static String replace(String input){
		// Write your code here
		return replaceString(input,0);
	}

    public static String replaceString(String input, int startIndex){
        int index = input.indexOf("pi");
        if(index >= 0){
            input = input.replace("pi", "3.14");
            if(index < input.length()-2){
                return ans = input;
            }
            replaceString(input, startIndex + 1);
        }
        return input;
    }

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(ReplacePi.replace(input));
        s.close();
	}    
}