package DP;

import java.io.*;

/**
 * MinCountOfSqures
 */
public class MinCountOfSqures {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(MinCountOfSqures.minCountDP(n));
            System.out.println(MinCountOfSqures.minCountM(n));
            System.out.println(MinCountOfSqures.minCount(n));
    }

    public static int minCount(int n) {
		//Your code goes here
        if(n==0){
            return 0;
        }if(n==1){
            return 1;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i++){
            min = Math.min(min, minCount(n-(i*i)));
		}
        return min + 1;
	}
	
    public static int minCountM(int n){
        int storage[] = new int[n+1];
        return helperM(n,storage);
    }
    
    public static int helperM( int n, int storage[]){
        if(n==0 || n == 1){
            storage[n] = n;
            return storage[n];
        }
        if(storage[n] != 0){
            return  storage[n];
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i++){
            min = Math.min(min, helperM(n-(i*i), storage));
		}
        storage[n] = min+1;
        return storage[n];
    }
    
    public static int minCountDP(int n){
        int[] storage  = new int[n+1];
		storage[0]=0;
		storage[1] =1;
		for(int i=2;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1;j<=Math.sqrt(i);j++) {
				int count = storage[i-(j*j)];
				if(min > count) {
					min = count;
				}
				
			}
			storage[i] = min + 1;
			
		}
		return storage[n];
    }
}