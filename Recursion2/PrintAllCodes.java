package Recursion2;

import java.util.Scanner;

public class PrintAllCodes{

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		PrintAllCodes.printAllPossibleCodes(input);
        s.close();
	}
    
    public static void printAllPossibleCodes(String input) {
        // here we initialize a empty String output 
        String output="";
        // now we are calling the helper function 
       helper(input,output);
        return;
    }
    // we had to call this helper function just to use the output String while recursion 
    private static void helper(String input,String output){
        /**BASE CASE
         *  if the length of input is equal to zero
         * then we will print the output that we got till now 
         * and than return 
         */
        if(input.length()==0)
        {  System.out.println(output);
        return;
        }

        // here we are initializing the character ch1 with the helper1 function
        char ch1=helper1(input.charAt(0)-'0');
        /** Recursion 
         * here we are calling the helper function with the first input as input.substring starting from 1
         * and the second output containg the sum of output and character ch1
         */
        helper(input.substring(1),output+ch1);

        /**
         * if the length of input is greater or equal to 2
         * we will first initialize the character ch2 containing character at index 0 of input minus the character '0'
         * then we will initialize the character ch3 containing character at index 1 of input minus the character '0'
         */
        if(input.length()>=2)
        {
            int ch2=input.charAt(0)-'0';
            int ch3=input.charAt(1)-'0';
            // now we will make a two digit number out of previous two integers
            int x=ch2*10+ch3;
            /**
             * if x is greater or equal to 10 and x is also smaller or equal to 26
             * then we will initialize the character ch4 containing helper1 which is containing x
             * then we will call the recursion with helper function 
             *      containing input substring from index 2 and the sum of output and character ch4
             */
            if(x>=10 && x<=26)
            {
                char ch4=helper1(x);
                helper(input.substring(2),output+ch4);   
            }        
        }
        return;
    }
    // here we are initializing the helper1 character containing the Integer ch
    private static char helper1(int ch){
        // now we are returning the typecasted character containing character 'a' plus the integer ch minus 1
        return (char)('a'+ch-1);
    }
}