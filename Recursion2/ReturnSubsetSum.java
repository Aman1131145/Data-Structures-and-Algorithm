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
		int output[][] = ReturnSubsetSum.subsetsSumK(input, k);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}  
    
	public static int[][] subsetsSumK(int[] input, int k) {
		return subsetsSumK(input, k, 0);
	}

    private static int[][] subsetsSumK(int[] input, int k, int startIndex) {
        if(startIndex >= input.length){
			int[][] answer = new int[1][0];
            return answer;
        }
        int answer[] = new int[2];        
        for(int i = 0; i < input.length; i++){
            for(int j = i+1; j < input.length; j++){
				if(input[i] + input[j] == k){
					answer[0][] = i;
					answer[1][] = j;
					break;
				}
			}
        }
        return answer;
		// int[][]smallAns = subsetsSumK(input,startIndex+1);
		// int[][] ans = new int[smallAns.length*2][];
		// int c = 0;
		// for(int i = 0; i < smallAns.length; i++){
        //     ans[i] = new int[smallAns[i].length];
		// 	for(int j = 0; j < smallAns[i].length; j++){
		// 		ans[i][j] = smallAns[i][j];
		// 	}
		// 	c++;
        // }
        // for(int i = 0; i < smallAns.length; i++){
        //     ans[c+i] = new int[smallAns[i].length + 1];
		// 	ans[c+i][0] = input[startIndex];
		// 	for(int j = 1; j <= smallAns[i].length; j++){
		// 		ans[i+c][j] = smallAns[i][j-1];
		// 	}
        // }
		// return ans;
    }
}