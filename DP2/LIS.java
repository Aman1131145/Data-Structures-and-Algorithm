package DP2;

import java.io.*;

public class LIS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];
        if (size == 0) {
            return input;
        }
		String[] strNums;
		strNums = br.readLine().split("\\s");
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }
        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput();
        System.out.println(LIS.lis(arr));
    }

    public static int lis(int arr[]) {
        int[] storage = new int[arr.length];
		storage[0] =1;

		for(int i=1;i<arr.length;i++) {
			int max = 0;
			for(int j=i-1;j>=0;j--) {

				if(arr[i] > arr[j] && max < storage[j] ) {
					max = storage[j];
				}

			}
			storage[i] = max +1;

		}
		int max = Integer.MIN_VALUE;
		for(int i : storage) {
			max =  max < i ? i : max ;
		}
		return max;
    }
}