package Recursion2_Repeat;

import java.util.Scanner;

public class PrintSubsequences {
    static int count = 0;
    private static void printSubsequences(String string) {
        printSubsequences(string , "");
    }
    private static void printSubsequences(String input, String outSoFar) {
        if(input.isEmpty()){
            System.out.println(outSoFar);
            return;
        }
        printSubsequences(input.substring(1), outSoFar);
        printSubsequences(input.substring(1), outSoFar + input.charAt(0));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        printSubsequences(input);
        sc.close();
    } 
}