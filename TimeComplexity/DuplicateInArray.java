package TimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DuplicateInArray {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = 11;//Integer.parseInt(br.readLine().trim());
        int[] input = {5,5,1,6,8,3,0,2,7,4};//new int[size];
        if (size == 0) {
            return input;
        }
        //String[] strNums; 
        //strNums = br.readLine().split("\\s");
        // for(int i = 0; i < size; ++i) {
        //     input[i] = Integer.parseInt(strNums[i]);
        // }
        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = 1;//Integer.parseInt(br.readLine().trim());
        while(t > 0) {
            int[] arr = takeInput();
            System.out.println(DuplicateInArray.duplicateInArray(arr));
            t -= 1;
        }
    }

    public static int duplicateInArray(int[] arr) {
        int ans = 0;
        int n = arr.length-1;
        int sum = (n*(n-1))/2;
        for(int i = 0; i < arr.length; i++){
            ans = ans+arr[i];
        }
        return ans-sum;
    }

    
}
