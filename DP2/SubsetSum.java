package DP2;

import java.io.*;

public class SubsetSum {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            System.out.print("No");
            return;
        }
        
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        int sum = Integer.parseInt(br.readLine().trim());
        if (SubsetSum.isSubsetPresent(input,size,sum)){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }


    }

    static boolean isSubsetPresent(int[] arr, int n, int sum) {

        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        //dp[i][j] is true if we can create arr subset sum of j from first i elements
        boolean[][] dp = new boolean [n + 1][sum + 1];
        //If sum is 0, then answer is true
        for (int i = 0; i <= n; i++){
        	dp[i][0] = true;
        }
        //If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++){
        	dp[0][i] = false;
        }
        //Fill the table in bottom up manner
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= sum; j++){
                if (j < arr[i - 1]){
                	dp[i][j] = dp[i - 1][j];
                }
                else{
                	dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        boolean result = dp[n][sum];
        return result;
    }
    
}
