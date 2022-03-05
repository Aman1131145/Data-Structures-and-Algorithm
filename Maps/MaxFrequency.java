package Maps;

import java.io.*;
import java.util.*;

public class MaxFrequency {

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
        System.out.println(MaxFrequency.maxFrequencyNumber(arr));
    }

    public static int maxFrequencyNumber(int[] arr){ 
		HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1 );
			}else {
				map.put(i, 1);
			}
        }
        int maxFreq = 0;
		int max = Integer.MIN_VALUE;
		for(int i : arr) {
			if( maxFreq < map.get(i) ) {
				maxFreq = map.get(i);
				max = i;
			}
		}
		return max;
    }
}
