package Recursion2;

import java.util.Scanner;

public class RemoveOccurences {

    public static String removeOccurence(String s){
		// Write your code here
		if(s.length()<=1){
            return s;
        }
        String smallans=removeOccurence(s.substring(1));
        if(s.charAt(0) == smallans.charAt(0)){
            return smallans;
        }else{
            return s.charAt(0) + smallans;
        }
	}
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = "xxxyyyzwwzzz";//s.nextLine();
		System.out.println(RemoveOccurences.removeOccurence(input));
        s.close();
	}
    
}
