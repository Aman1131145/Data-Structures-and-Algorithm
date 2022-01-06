package Recursion2;

import java.util.Scanner;

public class KeypadProblem {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int input = 23;//s.nextInt();
		String output[] = KeypadProblem.keypad(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
        s.close();
    }

	public static String[] keypad(int n){
		if(n==0||n==1){
			String[] finalAns = {""};
			return finalAns;
		}

		int num = n%10;
		String[] ans = keypad(n/10);
		String smallAns = helper(num);

		String finalAns[] = new String[ans.length*smallAns.length()];

		int k = 0;		
		for(int i = 0; i < ans.length; i++){
			for(int j = 0; j < smallAns.length(); j++){
				finalAns[k] = ans[i] + smallAns.charAt(j);
				k++;		 
			}
		}
		return finalAns;
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
			return "wxyz";
		}
		else{
			return "";
		}	
	}
}