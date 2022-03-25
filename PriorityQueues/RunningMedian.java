package PriorityQueues;

import java.util.*;
import java.io.*;

/**
 * RunningMedian
 */
public class RunningMedian {

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
        RunningMedian.findMedian(arr);


    }

    public static void findMedian(int arr[]) {
        int n = arr.length;
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return (second - first);
            }
        });
        PriorityQueue<Integer> higherHalf = new PriorityQueue<>();
        int median;
        //size is the size of the current stream
        for(int size = 1; size <= n; size++) {
            if(!lowerHalf.isEmpty() && lowerHalf.peek() > arr[size-1]) {
                lowerHalf.add(arr[size - 1]);
                if(lowerHalf.size() > higherHalf.size() + 1) {
                    higherHalf.add(lowerHalf.poll());
                }
            } else {
                higherHalf.add(arr[size - 1]);
                if(higherHalf.size() > lowerHalf.size() + 1) {
                    lowerHalf.add(higherHalf.poll());
                }
            }
            if(size % 2 == 1) {
                if(higherHalf.size() > lowerHalf.size()) {
                    median = higherHalf.peek();
                } else {
                    median = lowerHalf.peek();
                }
            } else {
                median = (lowerHalf.peek() + higherHalf.peek()) / 2;
            }
            System.out.print(median + " ");
        }
    }
}