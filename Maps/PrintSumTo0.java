package Maps;

import java.util.*;
import java.io.*;

public class PrintSumTo0 {

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
        System.out.print(PrintSumTo0.PairSum(arr,arr.length));
    }

    public static int PairSum(int[] input, int size) {
        if(size==0){
            return 0;
        }
        int ans = 0;
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<size;i++)
        {   
            if(h.containsKey(-input[i]) && h.get(-input[i])!=0){
                int count = h.get(-input[i]);
                while(count!=0){
                	ans++;
                 	count--;
                }
                if(h.containsKey(input[i]))
                    h.put(input[i],h.get(input[i])+1);
                else
                    h.put(input[i],1);
            }
            else{
                if(h.containsKey(input[i])){
                    h.put(input[i],h.get(input[i])+1);
                }else{
                    h.put(input[i] ,1);
                }
            }
        }
        return ans;
	}    
}