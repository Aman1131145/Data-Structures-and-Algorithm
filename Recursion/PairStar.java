package Recursion;

import java.util.Scanner;

public class PairStar {

    // Return the changed string
	public static String pairStar(String s){
		// Write your code here
		if(s.length()==1)
            return s;
        String smallans=pairStar(s.substring(1));
        if(s.charAt(0)==smallans.charAt(0))
            return s.charAt(0)+"*"+smallans;
        else
            return s.charAt(0)+smallans;
        //return pairStar(input,0);
	}
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = "ababaab";//s.nextLine();
		System.out.println(PairStar.pairStar(input));
        s.close();
	}    
    
}
