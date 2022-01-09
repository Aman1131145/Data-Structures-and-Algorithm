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
        if(startIndex >= input.length){
			int[][] answer = new int[1][0];
            return answer;
        }
		int[][]smallAns = subsets(input,startIndex+1);
		int[][] ans = new int[smallAns.length*2][];
		int k = 0;
		for(int i = 0; i < smallAns.length; i++){
            ans[i] = new int[smallAns[i].length];
			for(int j = 0; j < smallAns[i].length; j++){
				ans[i][j] = smallAns[i][j];
			}
			k++;
        }
        for(int i = 0; i < smallAns.length; i++){
            ans[k+i] = new int[smallAns[i].length + 1];
			ans[k+i][0] = input[startIndex];
			for(int j = 1; j <= smallAns[i].length; j++){
				ans[i+k][j] = smallAns[i][j-1];
			}
        }
		return ans;
	}
}