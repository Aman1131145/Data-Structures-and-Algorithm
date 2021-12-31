package Recursion;

import java.util.Scanner;

public class Multiplication{

    public static int multiplication(int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }
        int ans = m + multiplication(m,n-1);
        return ans ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(multiplication(m,n));
        sc.close();
    }
    
}