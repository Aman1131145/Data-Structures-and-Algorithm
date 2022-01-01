package Recursion;

import java.util.Scanner;

public class StringToInteger {

    public static int convertStringToInt(String input)
    {
		// Write your code here
        return convertStringToInt(input,0);
	}
    
    public static int convertStringToInt(String input, int startIndex)
    {
        if(input.length()==0)
        {
            return 0;
        }
        if(input.charAt(startIndex) == 0){
            input = input.replace("0","");
            System.out.println(input);
            convertStringToInt(input, startIndex + 1);
        }
        int number = Integer.parseInt(input);
        return number;
    }

    public static void main(String[] args) 
    {
		Scanner s = new Scanner(System.in);
		String input = "00014502";//s.nextLine();
		System.out.println(StringToInteger.convertStringToInt(input));
        s.close();
	}
    
}
