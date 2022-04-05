package DP;

import java.io.*;

public class Staircase {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(Staircase.staircaseR(n));
            System.out.println(Staircase.staircaseM(n));
            System.out.println(Staircase.staircaseDP(n));
    }
    
    public static long staircaseR(int n) {
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        long x = staircaseR(n - 1);
        long y = staircaseR(n - 2);
        long z = staircaseR(n - 3);
        return x+y+z;
	}

    public static long staircaseM(int n, long storage[]){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        long x = staircaseM(n - 1, storage);
        long y = staircaseM(n - 2, storage);
        long z = staircaseM(n - 3, storage);
        storage[n] = x+y+z;
        return storage[n];
    }
    
    public static long staircaseM(int n){
        long storage[] = new long[n+1];
        return staircaseM(n, storage);
    }

    public static long staircaseDP(int n){
        if(n==0 || n==1){
            return 1;
        }if(n==2){
            return 2;
        }
        long storage[] = new long[n+1];
        
        storage[0] = 1;
        storage[1] = 1;
        storage[2] = 2;
        
        for(int i = 3; i < n+1; i++){
            storage[i] = storage[i-1] + storage[i-2] + storage[i-3];
        }
        return storage[n];
    }
}