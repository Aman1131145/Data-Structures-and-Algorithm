package Maps;

import java.io.*;
import java.util.*;

public class LongestConsucutiveSequence {
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

    public static void printArray(ArrayList<Integer> arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        ArrayList<Integer> ans = LongestConsucutiveSequence.longestConsecutiveIncreasingSequence(arr);
        printArray(ans);

    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        HashMap<Integer,Boolean> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],true);
        }
        
        int maxlength = 0;
        int start  = 0;
        
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])){
                int length = 0;
                int temp = arr[i];
                while(map.containsKey(temp)){
                    length++;
                    map.put(temp,false);
                    temp = temp+1;
                }
                int starttemp = arr[i];
                temp = arr[i]-1;
                while(map.containsKey(temp)){
                    length++;
                    map.put(temp,false);
                    starttemp = temp;
                    temp = temp-1;
                }
                
                if(length > maxlength){
                    maxlength = length;
                    start = starttemp;
                }else if(length == maxlength){
                    maxlength = length;
                    //start = 10 starttemp = 4
                    for(int j=0;j<arr.length;j++){
                        if(arr[j] == start){
                            break;
                        }else if(arr[j] == starttemp){
                            start = starttemp;
                            break;
                        }
                    }
                }
            }
            // else{
            //     continue;
            // }
        }
        
        output.add(start);
        output.add(start + maxlength - 1);
       // for(int i = start;i<start+maxlength;i++){
       //     output.add(i);
       // }
        
        return output;
        
    }
    
}
