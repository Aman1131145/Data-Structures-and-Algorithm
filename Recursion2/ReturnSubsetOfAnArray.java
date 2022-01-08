package Recursion2;

import java.util.Scanner;

public class ReturnSubsetOfAnArray {

    public static int[] takeInput() {
	    Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
        s.close();
		return arr;
    }
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int output[][] = ReturnSubsetOfAnArray.subsets(input);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

    public static int[][] subsets(int[] input) {
        if(input.length == 0){
            return null;
        }
		return subsets(input);
    }
    
}
