package Recursion2_Repeat.Sorting;

import java.util.Scanner;

public class SelectionSort {

    public static int[] selectionSort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
 
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter the element " + i + " : ");
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        System.out.println("Sorted array: ");
        printArray(arr, n);
        sc.close();
    }
    
}
