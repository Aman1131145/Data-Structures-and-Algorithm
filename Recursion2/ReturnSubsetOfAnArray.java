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

	public static int[][] subsets(int[] input){
		return subsets(input, 0);
	}

    public static int[][] subsets(int[] input,int startIndex) {
		// checks if start index is larger or equal to the input's length
        if(startIndex >= input.length){			
			// creates a new 2D array answer with only one column in its first row
			int[][] answer = new int[1][0];		
			// returns the empty array
            return answer;						
        }
		// creates an 2D array smallAns which is responsible for the recursive call
		int[][]smallAns = subsets(input,startIndex+1);
		/**
		 * creates an 2D array ans with length double the size of smallAns
		 * because it will have the small arrays which will store 
		 * the subSets 
		 */
		int[][] ans = new int[smallAns.length*2][];
		/**
		 * this will ensure that we are itrating through indexes of ans array 
		 * one after another and not repeat the same index over and over 
		 */
		int k = 0;
		// this for loop will create an array inside the array ans 
		for(int i = 0; i < smallAns.length; i++){
            ans[i] = new int[smallAns[i].length];
			// this for loop will copy smallAns to ans 
			for(int j = 0; j < smallAns[i].length; j++){
				ans[i][j] = smallAns[i][j];
			}
			//this will itrate to the next index in the ans array
			k++;
        }
		// this for loop will itrate through the smallAns 
        for(int i = 0; i < smallAns.length; i++){
			// this will create a new array of length smallAns.length + 1 within the 2D array ans 
            ans[k+i] = new int[smallAns[i].length + 1];
			// this will copy the element at startindex of input to the k+i th row (the row after the row till its printed teh ans) 
			ans[k+i][0] = input[startIndex];
			// this for loop will itrate through smallAns[i] array 
			for(int j = 1; j <= smallAns[i].length; j++){
				// this will copy the smallAns element at i th row and j-1 coloumn to ans array at i+k the row and j coloumn
				ans[i+k][j] = smallAns[i][j-1];
			}
        }
		// this will return the ans 
		return ans;
	}
}