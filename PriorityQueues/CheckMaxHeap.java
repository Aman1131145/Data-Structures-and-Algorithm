package PriorityQueues;

import java.util.*;
import java.io.*;

public class CheckMaxHeap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(CheckMaxHeap.checkMaxHeap(input));
	}

    public static boolean checkMaxHeap(int arr[]) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
        for(int i = 0; i < arr.length; i++){
            if((2*i)+1 >= arr.length || (2*i)+2 > arr.length){
                break;
            }
            else if((arr[i] <= arr[(2*i)+1]) && (arr[i] <= arr[(2*i)+2])){
                return false;
            }
        }
        return true;
	}
    
}
