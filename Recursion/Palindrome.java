package Recursion;

import java.util.Scanner;

public class Palindrome {

    public static boolean isStringPalindrome(String input){
        int arr1[] = new int[input.length()];
        int arr2[] = new int[input.length()];
        for(int i = 0; i < input.length()-1; i++){
            arr1[i] = input.charAt(i);
            arr2[i] = input.charAt(input.length()-i);
        }
        
        System.out.println(arr1);
        System.out.println(arr2);
        if(input.length() == 0){
            return false;
        }
        if(arr1 == arr2){
            return true;
        }else{
            return false;
        } 
    }
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = "rececar";
        System.out.println(Palindrome.isStringPalindrome(input));
        s.close();
	}
}
