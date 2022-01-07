package Recursion2;

import java.util.Scanner;

public class BinarySearch {

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
		int element = s.nextInt();
		System.out.println(BinarySearch.binarySearch(input,element));
    
    }

    public static int binarySearch(int[] input, int element) {
        // Write your code here.
        return binarySearch(input, 0, input.length - 1, element);
    }

    private static int binarySearch(int[] input, int start_index, int end_index, int element) {
        if(start_index>end_index){
            return -1;
        }
        int middle = (start_index+end_index)/2;

        if(input[middle] == element){
            return middle;
        }
        else if(input[middle] > element){
            return binarySearch(input, start_index, middle-1, element);
        }
        else{
            return binarySearch(input, middle+1, end_index, element);
        }
    }
        
}