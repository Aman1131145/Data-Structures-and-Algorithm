package Recursion;

import java.util.Scanner;

class Solution {

	public static void print(int n){
		
        if(n==0){
            return;
        }
        print(n-1);
        System.out.print(n + " ");
        
	}

}

public class OneToN {
    public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Solution.print(n);
        s.close();
	}
}


