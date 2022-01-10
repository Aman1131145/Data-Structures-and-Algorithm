package Recursion2;

import java.util.Scanner;

public class ReturnSubsetSum {

    static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		int answer[][] = ReturnSubsetSum.subsetsSumK(input, k);
		for(int i = 0; i < answer.length; i++) {
			for(int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}  
    
	public static int[][] subsetsSumK(int[] input, int k) {
        // this will call the subsetsetsSumK with an input a starting index and the sum whose components we want
		return subsetsSumK(input, k, 0);
	}

    private static int[][] subsetsSumK(int[] input, int k, int startIndex) {
        /**BASE CASE
         * if startIndex will be greater or equal to the length of input
         * and if all the elements of that subset will sum up to k 
		 * than we will return it as an answer
		 * otherwise we will return 
         */
        if(startIndex >= input.length){
			if(k == 0){
				return new int[1][0];
			}else{
				return new int[0][0];
			}
        }
        int answer1[][] = subsetsSumK(input, k-input[startIndex], startIndex+1);
        int answer2[][] = subsetsSumK(input, k, startIndex+1);
		int answer[][] = new int[answer1.length + answer2.length][];

		int l = 0 ;
		for(int i=0;i<answer2.length;i++){
			answer[i]=new int[answer2[i].length];
			for(int j=0;j<answer2[i].length;j++)
				answer[l][j]=answer2[i][j];
			l++;
		}
		for(int i=0;i<answer1.length;i++){
			answer[i+l]=new int[answer1[i].length+1];
			answer[i+l][0]=input[startIndex];
			for(int j=1;j<=answer1[i].length;j++){
				answer[i+l][j]=answer1[i][j-1];
			}
		}
		return answer;
	}
}
