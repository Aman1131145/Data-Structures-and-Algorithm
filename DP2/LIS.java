package DP2;

import java.io.*;

public class LIS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];
        if (size == 0) {
            return input;
        }
		String[] strNums;
		strNums = br.readLine().split("\\s");
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }
        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput();
        System.out.println(LIS.lis(arr));
    }

    public static int lis(int arr[]) {
        return lis(arr,0);
    }
    public static int lis(int arr[], int si){
        if(si >= arr.length){
            return 0;
        }
        int op1 = 0, op2 = 0;
        
        return 1+Math.max(op1,op2);
    }
}