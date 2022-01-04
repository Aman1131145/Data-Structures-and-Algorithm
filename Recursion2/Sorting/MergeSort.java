package Recursion2.Sorting;

import java.util.Scanner;

public class MergeSort {

    public static void merge(int arr[] , int arr1[] , int arr2[]){
        int i=0,j=0,k=0;
        
        while(i<arr1.length && j<arr2.length){
        	if(arr1[i]<=arr2[j]){
                arr[k] = arr1[i];
                k++;
                i++;
            }    
            else{
                arr[k] = arr2[j];
                k++;
                j++;
            }   
        }
        while(i<arr1.length){
            arr[k] = arr1[i];
            k++;
            i++;
        }
        while(j<arr2.length){
            arr[k] = arr2[j];
            k++;
            j++;
        }
    }

	public static void mergeSort(int[] input){
		// Write your code here        
        if(input.length<=1){
            return;
        }
		
        int mid = input.length/2;
        
        int arr1[] = new int[mid];
        int arr2[] = new int[input.length-mid];
        
        for(int i=0;i<mid;i++){
            arr1[i] = input[i];
        }
        for(int j=mid;j<input.length;j++){
            arr2[j-mid] = input[j];
        }
        
        mergeSort(arr1);
        mergeSort(arr2);
        merge(input,arr1,arr2);
	}

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
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		MergeSort.mergeSort(input);
		printArray(input);
	}
}