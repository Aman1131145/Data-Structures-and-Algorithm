package DP;

import java.io.*;
import java.util.*;

public class ByteLandian {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            long n = Long.parseLong(br.readLine().trim());
            HashMap<Long, Long> memo = new HashMap<Long, Long>();
            System.out.println(ByteLandian.bytelandian(n,memo));
    }

    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Write your code here
        if(n == 0|| n == 1){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        long max = Math.max(n, bytelandian(n/2,memo) + bytelandian(n/3,memo) + bytelandian(n/4,memo));
        if(n<10000){
            memo.put(n,max);
        }
        return max;
        
	}
    
}
