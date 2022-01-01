package Recursion;

import java.util.Scanner;

public class SumOfAllDigits {

    public static int sumOfDigits(int input){
		// Write your code here
		int singleDigit = input%10;
		if(input/10 <= 1){
			return singleDigit + input/10;
		}
		int sum = singleDigit + sumOfDigits(input/10);
		return sum;

	}
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = 00000;//s.nextInt();
		System.out.println(SumOfAllDigits.sumOfDigits(n));
		s.close();
	}
    
}
