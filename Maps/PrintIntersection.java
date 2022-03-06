package Maps;

import java.util.*;
import java.io.*;

public class PrintIntersection {
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
        int[] arr1 = takeInput();
        int[] arr2 = takeInput();
        PrintIntersection.printIntersection(arr1,arr2);
    }

    public static void printIntersection(int[] arr1,int[] arr2){
		HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr1){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        for (int i = 0; i < arr2.length; i++){
            if (map.containsKey(arr2[i])) {
                int freq = map.get(arr2[i]);
                if (freq > 0) {
                    System.out.println(arr2[i]);
                    map.put(arr2[i], freq-1);
                }
            }
        }
	}
}
