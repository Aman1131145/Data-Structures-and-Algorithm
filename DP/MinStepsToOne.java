package DP;

// import java.util.*;
import java.io.*;

public class MinStepsToOne {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = 10;//Integer.parseInt(br.readLine().trim());
            System.out.println(MinStepsToOne.countMinStepsToOne(n));
            System.out.println(countMinStepsToOne(n));
            System.out.println(countStepsDP(n));
    }
    
    public static int countMinStepsToOne(int n) {
		//Your code goes here
        if(n==1){
            return 0;
        }
        
        int min = countMinStepsToOne(n-1);
        if(n%2 == 0){
	        min = Math.min(min, countMinStepsToOne(n/2));
        }
        if(n%3 == 0){
            min = Math.min(min, countMinStepsToOne(n/3));
        }
        
        return min + 1;
	}

    public static int countStepsM(int n){
        int storage[] = new int[n+1];
        return helperM(n,storage);
    }

    public static int helperM(int n, int storage[]){
        if(n==1){
            storage[n] = 0;
            return storage[n];
        }
        if(storage[n] != 0){
            return storage[n];
        }
        int min = helperM(n-1, storage);
        if(n%2 == 0){
	        min = Math.min(min, helperM(n/2, storage));
        }
        if(n%3 == 0){
            min = Math.min(min, helperM(n/3, storage));
        }

        storage[n] = 1 + min;
        return storage[n]; 
    }

    public static int countStepsDP(int n){
        int storage[] = new int[n+1];
        storage[1] = 0;

        for(int i = 2; i < storage.length; i++){
            int min = storage[i-1];
            if(i%3 == 0){
                min = Math.min(min, storage[i/3]);
            }
            if(i%2 == 0){
                min = Math.min(min, storage[i/2]);
            }
            storage[i] = 1 + min;
        } 
        return storage[n];
    }
}
