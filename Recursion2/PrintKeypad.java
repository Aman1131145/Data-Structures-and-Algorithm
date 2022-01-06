package Recursion2;

import java.util.Scanner;

public class PrintKeypad {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		// int input = s.nextInt();
        printKeypad(23);
		s.close();
    }

    public static void printKeypad(int input){
        printKeypad(input, "");
    }

	private static void printKeypad(int input, String outSoFar) {
        if(input == 1){
            System.out.println("");
        }
        if(input == 0){
            System.out.println(outSoFar);
            return;
        }

        String num = helper(input%10);
        input = input/10;
        if(num.length() == 3){
            printKeypad(input, num.substring(0,1) + outSoFar);
        	printKeypad(input, num.substring(1,2) + outSoFar);
        	printKeypad(input, num.substring(2,3) + outSoFar);
        }
        if(num.length() == 4){
            printKeypad(input, num.substring(0,1) + outSoFar);
        	printKeypad(input, num.substring(1,2) + outSoFar);
        	printKeypad(input, num.substring(2,3) + outSoFar);
        	printKeypad(input, num.substring(3,4) + outSoFar);
        }
		
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

