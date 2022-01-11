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
					System.out.println(output[i]);
				}
			}
			else {
				return;
			}
		}

		output = new int[output.length + 1];
		for(int i = startindex; i < output.length; i++){
			output[i] = input[i];
		}
		printSubsetsSumTok(input, k - input[startindex], startindex + 1, output);
		printSubsetsSumTok(input, k, startindex + 1, output);
	}
    
    
}
