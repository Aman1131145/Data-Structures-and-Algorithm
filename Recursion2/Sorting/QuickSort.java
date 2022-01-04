package Recursion2.Sorting;

import java.util.Scanner;

public class QuickSort {

	private static void swap(int[] arr, int i, int j){
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
	}

    public static void quickSort(int[] input) {
		sort(input, 0, input.length - 1);
	}

    private static void sort(int[] input, int startIndex, int endIndex) {
        if(startIndex >= endIndex){
            return;
        }
		if(startIndex < endIndex){
			int pivotPos = partition(input, startIndex, endIndex);
	 
			sort(input, startIndex, pivotPos-1);
			sort(input, pivotPos + 1, endIndex);
		}
        
    }

    private static int partition(int[] input, int startIndex, int endIndex) {
        int pivot = input[endIndex];

        int i = (startIndex-1);

       for(int j = startIndex; j <= endIndex; j++){
		   if(input[j]<pivot){
			   i++;
			   swap(input, i, j);
		   }
	   }
	   swap(input, i+1, endIndex);
	   return i+1;
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