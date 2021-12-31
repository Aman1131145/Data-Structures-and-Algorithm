package Recursion;

import java.util.Scanner;

public class CountZeros {

    
    static int count = 0;
    public static int countZeros(int input){

        if(input == 0){
            return 0;
        }
        
        if(input%10 > 0){
            countZeros(input/10);
        }
        
        if(input%10 == 0){
            count = count + 1;
            countZeros(input/10);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int n = 500010;
		System.out.println(CountZeros.countZeros(n));
        s.close();
    }
}