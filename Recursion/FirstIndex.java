package Recursion;

import java.util.Scanner;

public class FirstIndex {

    public static int firstIndex(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/

        return firstIndex(input, x, 0);
		
	}

	public static int firstIndex(int input[], int x, int startingIndex){
		if(startingIndex == input.length){
			return -1;
		}
		if(input[startingIndex] == x){
			return startingIndex;
		}
		
		return firstIndex(input,x,startingIndex+1);
	}

	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = {9,8,10,8};
		int x = 8;
		System.out.println(FirstIndex.firstIndex(input, x));
	}
}

