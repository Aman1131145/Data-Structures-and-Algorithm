package Recursion2;

import java.util.Scanner;

public class PrintSubsetSum {

    static Scanner s = new Scanner(System.in);
 	public static int[] takeInput() {
		//int size = s.nextInt();
		int arr[] = {5,1,2,6,7,4,3};//new int[size];
		// for (int i = 0; i < size; i++) {
		// 	arr[i] = s.nextInt();
		// }
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = 9;//s.nextInt();
		PrintSubsetSum.printSubsetsSum(input, k);
	}

	public static void printSubsetsSum(int input[], int k) {
		// Write your code here
		int output[] = new int[0];
		printSubsetsSumTok(input, k, 0, output);
	}

	private static void printSubsetsSumTok(int[] input, int k, int startindex, int output[]) {
		if(startindex == input.length){
			if(k == 0 ){
				for(int i = 0; i < output.length; i++){
					System.out.print	(output[i] + " ");
				}
				System.out.println();
				return;
			}
			else {
				return;
			}
		}
		printSubsetsSumTok(input, k, startindex + 1, output);

		int[] newOutput = new int[output.length + 1];
		int i = 0;
		for(; i <= output.length-1; i++){
			newOutput[i] = output[i];
		}
			newOutput[i] = input[startindex];
		printSubsetsSumTok(input, k - input[startindex], startindex + 1, newOutput);
	}
    
    
}
