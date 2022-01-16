package TimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripleSum {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        //int size = Integer.parseInt(br.readLine().trim());
        int[] input = {6,1,6,5,3,2,5,0,5,6,0};//new int[size];

        // if (size == 0) {
        //     return input;
        // }
        
        // String[] strNums; 
        // strNums = br.readLine().split("\\s");
        

        // for (int i = 0; i < size; ++i) {
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
            int num = 5;//Integer.parseInt(br.readLine().trim());
            System.out.println(TripleSum.tripleSumOOfN(arr, num));
            t -= 1;
        }
    }

    public static int tripleSumOOfN(int[] arr, int num) 
    {
        int sumPair = 0;
        Arrays.sort(arr);
        return tripleSum(arr, num, 0, arr.length-1, sumPair);
    }

    public static int tripleSum(int[] arr, int num, int i, int j, int sumPair) 
    {
        System.out.println("Ja to rha hai");
        int k = num - arr[i] - arr[j];
        if(j <= i)
        {
            return sumPair;
        }
        if(arr[i] < k && k < arr[j]){
            sumPair++;
            if(arr[i] + arr[j] < num){
                tripleSum(arr, num, i+1, j, sumPair);
            }else{
                tripleSum(arr, num, i, j-1, sumPair);
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

    public static int tripletSum(int arr[], int k){
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int temp = k- arr[i];
            // finding pairs of temp;
            count += findPair(arr, i+1, n-1, temp);
        }

        return count;
    }

    private static int findPair(int arr[], int sI, int eI, int key){
        int numPair = 0;
        while(sI < eI){
            if(arr[sI] + arr[eI] > key)
                eI--;
            else if(arr[sI] + arr[eI] < key)
                sI++;
            else{
                // if both elements are same;
                if(arr[sI] == arr[eI]){
                    int num = (eI - sI) + 1;
                    numPair += num*(num-1)/2;
                    return numPair;
                }

                int siEle = arr[sI];
                int eiEle = arr[eI];
                int tempSi = sI + 1;
                int tempEi = eI - 1;

                while(tempSi <= tempEi && arr[tempSi] == siEle)
                    tempSi++;

                while(tempSi <= tempEi && arr[tempEi] == eiEle)
                    tempEi--;

                int totalElementFromStart = tempSi - sI;
                int totalElementFromEnd = eI - tempEi;

                numPair += (totalElementFromEnd * totalElementFromStart);

                sI = tempSi;
                eI = tempEi;

            }

        }
        return numPair;


    }                              
}