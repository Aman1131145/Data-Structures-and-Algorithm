package TimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TripleSum {

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
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr = takeInput();
            int num = Integer.parseInt(br.readLine().trim());
            System.out.println(TripleSum.tripleSumOOfN(arr, num));
            t -= 1;
        }
    }

    public static int tripleSumOOfN(int[] arr, int num) {
        int sumPair = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] == num){
                        sumPair++;
                    }
                }
            }
        }
        return sumPair;
    }

    public static int tripleSum(int[] arr, int num) {
        int sumPair = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] == num){
                        sumPair++;
                    }
                }
            }
        }
        return sumPair;
    }
}