package Recursion2;

import java.util.Scanner;

public class ReplaceCharacter {

    public static String replaceCharacter(String input, char c1, char c2){
        String s = String.valueOf(c1);
        String r = String.valueOf(c2);
        input = input.replaceAll(s, r);
        return input;
    }

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		char c1 = s.next().charAt(0);
		char c2 = s.next().charAt(0);
		System.out.println(ReplaceCharacter.replaceCharacter(input, c1, c2));
        s.close();
	}
}