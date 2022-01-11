package Recursion2;

import java.util.Scanner;

public class ReturnAllCode {

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String output[] = ReturnAllCode.getCode(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
        s.close();
	}

    public static String[] getCode(String input) {
        return null;
    }

    private static String helper(int n){
        if(n == 1){
            return "a";
        }
        if(n == 2){
            return "b";
        }
        if(n == 3){
            return "c";
        }
        if(n == 4){
            return "d";
        }
        if(n == 5){
            return "e";
        }
        if(n == 6){
            return "f";
        }
        if(n == 7){
            return "g";
        }
        if(n == 8){
            return "h";
        }
        if(n == 9){
            return "i";
        }
        if(n == 10){
            return "j";
        }
        if(n == 11){
            return "k";
        }
        if(n == 12){
            return "l";
        }
        if(n == 13){
            return "m";
        }
        if(n == 14){
            return "n";
        }
        if(n == 15){
            return "o";
        }
        if(n == 16){
            return "p";
        }
        if(n == 17){
            return "q";
        }
        if(n == 18){
            return "r";
        }
        if(n == 19){
            return "s";
        }
        if(n == 20){
            return "t";
        }
        if(n == 21){
            return "u";
        }
        if(n == 22){
            return "v";
        }
        if(n == 23){
            return "w";
        }
        if(n == 24){
            return "x";
        }
        if(n == 25){
            return "y";
        }
        if(n == 26){
            return "z";
        }
        else{
            return "";
        }
    }
    
}
