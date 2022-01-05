package Recursion2;

import java.util.Scanner;

public class KeypadProblem {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		String output[] = KeypadProblem.keypad(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
        s.close();
    }

	private static String[] keypad(int n){
		if(n==0||n==1){
			String[] ans = {""};
			return ans;
		}

		int num = n%10;
		String[] ans = keypad(n/10);
		String helpAns = helper(num);

		String 
		
	}

	private static String helper(int num){
		if(num == 2){
			return "abc";
		}
		if(num == 3){
			return "def";
		}
		if(num == 4){
			return "ghi";
		}
		if(num == 5){
			return "jkl";
		}
		if(num == 6){
			return "mno";
		}
		if(num == 7){
			return "pqrs";
		}
		if(num == 8){
			return "tuv";
		}
		if(num == 9){
			return "xyz";
		}
		else{
			return "";
		}
		
	}

}
 