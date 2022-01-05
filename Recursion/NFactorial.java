package Recursion;

import java.util.Scanner;

public class NFactorial {

    public static long fact(long n){
        if(n==0){
            return 1;            
        }
        
        long smallAns = fact(n-1);
        return n * smallAns;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = fact(n);
        System.out.println(ans);
        sc.close();
    }
}