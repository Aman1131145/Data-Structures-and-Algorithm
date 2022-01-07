package Recursion2;

import java.util.Scanner;

public class CheckAB {

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = "abbaabb";//s.next();
        System.out.println(CheckAB.checkAB(input));
		s.close();
	}

    public static boolean checkAB(String input) {
        if(input.length() == 0){
            return true;
        }
        if(input.charAt(0) == 'a'){
            if(input.substring(1).length() > 1 && input.substring(1,3).equals("bb")){
                return checkAB(input.substring(3));
            }else{
                 return checkAB(input.substring(1));
            }
        }
        return false;
    }
}
