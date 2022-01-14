package Recursion2;

import java.util.Scanner;

public class ReturnAllCode 
{
    public static void main(String[] args) 
    {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String output[] = ReturnAllCode.getCode(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
        s.close();
	}
    public static String[] getCode(String input)
    {
        /**BASE CASE
         *  here we will check if the length of the input array is equal to zero or not 
         * if the length of the input array is equal to zero then we will 
         * 1. Create an empty array called ans 
         * 2. Then we will return the answer 
         */
        if(input.length()==0){
            String ans[]={""};
            return ans;
        }
        // RECURSION 
  		// here we create a new array of string smallans we will
        String smallans[]=getCode(input.substring(1));
       
        // here we are initalizing the Integer 'an' by providing it with the ascii value of the first character of input
        int an=input.charAt(0)-'0';
        // here we are converting an to char
        char firstchar=(char)('a'+an-1);
      
        // here we are calling a for loop itriting from 0 to the length of smallans
        for(int i=0;i<smallans.length;i++){
            // here we are copying the sum of firstchar and the character at the "i"th position of smallans to the i"th position of smallans
            smallans[i] = firstchar+smallans[i];
        }
        
        // now we are initializing the empty String jagged array smallans1 
        String smallans1[]=new String[0];
        /** 
         * now if the length of input is greater or equal to 2 
         * 1. we will initialize the integer ch1 containing the input from the index 0 minus the character '0'
         * 2. we will initialize the integer ch2 containing the input from the index 1 minus the character '0'
         * 3. we will initialize the integer ch3 containing a two digit number made with ch1 and ch2
         */ 
        if(input.length()>=2)
        {
        	int ch1=input.charAt(0)-'0';
            int ch2=input.charAt(1)-'0';
            int an3=(ch1*10)+ch2;
               
            /**
             * now if ans3 is greater or equal to 10 and it is also smaller or equal to 26 then 
             * 1. we will initialize the character firsttwochar containing 'a' plus an3 minus 1
             * 2. we will call getCode containing the substring of input from index 2
             */
            if(an3>=10 && an3<=26)
            {
                char firsttwochar=(char)('a'+an3-1);
                smallans1=getCode(input.substring(2));
                // now we will call another for loop running from 0 to the length of smallans1
        		for(int i=0;i<smallans1.length;i++)
                {
                    // here we are copying the sum of firsttwochar and the character at index i of smallans to the index i of smallans1
             		smallans1[i]=firsttwochar+smallans1[i];}
        		}
        }

        // now we are creating a string array output having double the size of smallans1
        String output[]=new String[smallans.length+smallans1.length];
        // now we initialize integer k with zero
        int k=0;
        // calling another for loop running from 0 to the length of smallans
        for(int i=0;i<smallans.length;i++)
        {
            // in this loop we copy the character at index i of smallans to the k index of the output array 
            output[k]=smallans[i];
            // now we will increase the value of k by 1 so teh smallans will not copy to the same index oner and over again 
            k++;
        }

        /**
         * here we are calling the same for loop as the previous one but for smallans1 array
         */
        for(int i=0;i<smallans1.length;i++)
        {
            output[k]=smallans1[i];
            k++;
        }
        // and here we are returning the output 
    	return output;
	}
}