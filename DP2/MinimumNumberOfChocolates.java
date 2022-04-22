package DP2;

import java.io.*;

public class MinimumNumberOfChocolates {

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


    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.print(MinimumNumberOfChocolates.getMin(arr,arr.length));


    }

    public static int getMin(int a[], int n){
        int i = 0, j = 0;
        int res = 0, val = 1;
        while (j < n - 1) {
            if (a[j] > a[j + 1]) {
                // decreasing sequence
                j += 1;
                continue;
            }
            if (i == j){
                // add the chocolates received by that
                // person
                res += val;
            }
            else {
                // end point of decreasing sequence
                res += get_sum(val, i, j);
                val = 1; // reset value at that index
            }
            if (a[j] < a[j + 1]){
                // increasing sequence
                val += 1;
            }
            else{
                // flat sequence
                val = 1;
            }
            j += 1;
            i = j;
        }
        // add value of chocolates at position n-1
        if (i == j){
            res += val;
        }
        else{
            res += get_sum(val, i, j);
        }
        return res;
    }

    // helper function to get sum of decreasing sequence
    public static int get_sum(int peak, int start, int end)
    {
        /* peak is the value obtained at peak point
           from previous flat/increasing sequence */
  
        /* value obtained from decreasing sequence
         also the count of values in the sequence*/
        int count = end - start + 1;
        /* assigning max of values obtained from
         increasing and decreasing sequences */
        peak = (peak > count) ? peak : count;
        /* sum of count - 1 values & peak value
         sum of natural numbers : (n * (n + 1))/2 */
        int s = peak + (((count - 1) * count) >> 1);
        return s;
    }
    
}
