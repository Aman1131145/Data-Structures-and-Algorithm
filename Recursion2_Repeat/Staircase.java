package Recursion2_Repeat;

import java.util.Scanner;

public class Staircase {

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = 4;//s.nextInt();
		System.out.println(Staircase.staircase(n));
        s.close();
        
	}

    private static int staircase(int n) {
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        int x = staircase(n - 1);
        int y = staircase(n - 2);
        int z = staircase(n - 3);
        return x+y+z;
    }    
}