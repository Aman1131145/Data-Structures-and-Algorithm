package DP;

import java.io.*;

public class NumberOfBalancedBTs {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        long longNumber = Integer.parseInt(br.readLine().trim());
        int integerNumber = (int) longNumber;
        System.out.println(NumberOfBalancedBTs.balancedBTsDP(integerNumber));
        System.out.println(NumberOfBalancedBTs.balancedBTs(longNumber));
    }

    public static long balancedBTs(long height){
        if(height == 0 || height == 1) {
			return 1;
		}
		int mod = (int)Math.pow(10, 9) + 7;
		long x = (long)balancedBTs(height-1);
		long y = (long)balancedBTs(height-2);
		
		long x_2 = (x*x)%mod;
		long x_y = (x*y)%mod;
		long x_y_2 = (2*x_y) % mod ;
		return (int)(x_2+x_y_2) % mod;
	}
    
    public static int balancedBTsDP(int height){
		int mod = (int)Math.pow(10, 9) + 7;
		int[] storage  = new int[height + 1];
		storage[0]=1;
		storage[1]=1;
		for(int i=2;i<=height;i++) {
			long x =(long) storage[i-1];
			long y = (long)storage[i-2];
			
			long x_2 =(x*x)% mod;
			long x_y_2 = (2*x*y)% mod;
			storage[i] = (int)(x_2+x_y_2)%mod;
		}
		return storage[height];

	}
}
