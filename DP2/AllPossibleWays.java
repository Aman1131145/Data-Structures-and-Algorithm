package DP2;

import java.io.*;

public class AllPossibleWays {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {

        String[] strNums;
		strNums = br.readLine().split("\\s");
        int x = Integer.parseInt(strNums[0]);
        int n = Integer.parseInt(strNums[1]);
        System.out.println(AllPossibleWays.allWays(x, n));
    }

    public static int allWays(int x, int n) {
        return checkRecursive(x,n,1,0);
    }
    
    private static int checkRecursive(int x, int n, int curr_num, int curr_sum){
        // Initialize number of ways to express
        // x as n-th powers of different natural
        // numbers
        int results = 0;
 
        // Calling power of 'i' raised to 'n'
        int p = (int)Math.pow(curr_num, n);
        
        while (p + curr_sum < x) {
            // Recursively check all greater values of i
            results += checkRecursive(x, n, curr_num + 1, p + curr_sum);
            curr_num++;
            p = (int)Math.pow(curr_num, n);
        }
 
        // If sum of powers is equal to x
        // then increase the value of result.
        if (p + curr_sum == x){
        	results++;
        }
        // Return the final result
        return results;
    }
}
