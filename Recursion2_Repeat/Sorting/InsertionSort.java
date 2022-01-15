package Recursion2_Repeat.Sorting;

import java.util.Scanner;

public class InsertionSort {

    public static int[] insertionSort(int arr[]){
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = n-1; i < 0; i++){
            // Find the minimum element in unsorted array
            int max_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] > arr[max_idx]){
                    j = max_idx;
                }
            // Swap the found minimum element with the first
            // element
            int temp = arr[max_idx];
            arr[max_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        int arr[] = {54,15,472,54,775,21};//new int[n];
        // for(int i = 0; i < n; i++){
        //     System.out.print("Enter the element " + i + " : ");
        //     arr[i] = sc.nextInt();
        // }
        insertionSort(arr);
        System.out.println("Sorted array: ");
        printArray(arr, arr.length);
        sc.close();
    }
    
}
