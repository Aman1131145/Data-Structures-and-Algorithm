package Recursion2_Repeat;

import java.util.Scanner;

public class RemoveX {

    private static String removeX(String input) {
        if(input.isEmpty()){
            return input;
        }
        if(input.charAt(0) == 'x'){
            input.replaceAll("x", "");
            return input;
        }
        return input;
    }    
    
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(RemoveX.removeX(input));
        s.close();
	}

}
