package Recursion2.Sorting;

import java.util.Scanner;

public class QuickSort {

    public static void quickSort(int[] input) {
		sort(input, 0, input.length - 1);
	}

    private static void sort(int[] input, int startIndex, int endIndex) {
        if(startIndex >= endIndex){
            return;
        }

        int pivotPos = partition(input, startIndex, endIndex);

        sort(input, startIndex, pivotPos-1);
        sort(input, pivotPos + 1, endIndex);
    }

    private static int partition(int[] input, int startIndex, int endIndex) {
        int count = 0;
        int pivot = input[startIndex];

        for(int i = startIndex; i <= endIndex; i++){
            if(pivot >= input[i]){
                count = count+1;
            }
        }

        int pivotPos = startIndex + count;
		int temp = input[pivotPos];
		input[pivotPos] = input[startIndex];
		input[startIndex] = temp;

        for(int i = startIndex; i <= pivotPos; i++){
			if(input[i]>input[pivotPos]){
                for(int j = endIndex; j > pivotPos; j--){
                    if(input[j] > input[pivotPos]){
                        int temp1 = input[j];
                        input[j] = input[i];
                        input[i] = temp1;
                    }
                }
            }
        }
		return pivotPos;
    }

    static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		// int size = s.nextInt();
		int[] input = {10,1,19,9,2,6,11};//new int[size];
		// for(int i = 0; i < size; i++){
		// 	input[i] = s.nextInt();
		// }
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		QuickSort.quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}   
}