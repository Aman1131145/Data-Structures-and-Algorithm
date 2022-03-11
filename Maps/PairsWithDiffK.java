package Maps;

import java.util.*;
import java.io.*;

public class PairsWithDiffK {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		System.out.println(PairsWithDiffK.getPairsWithDifferenceK(arr, k));
	}

    public static int getPairsWithDifferenceK(int input[], int k) {
		//Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairCount = 0;
        for(int i : input){
            int p1 = i + k;
            boolean flag = false;
            if(i == p1) {
                flag = true;
            }
            if(map.containsKey(p1)){
                pairCount += map.get(p1);
            }
            int p2 = i - k;
            if(map.containsKey(p2) && !flag){
                pairCount += map.get(p2);
            }
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }
        return pairCount;
        // HashMap<Integer,Integer> map=new HashMap<>();
        // int sum = 0;
        // for(int i=0;i<input.length;i++){
        //     if(!map.containsKey(input[i])){
        //         map.put(input[i],1);
        //     }else{
        //         int oldfreq=map.get(input[i]);
        //         map.put(input[i],oldfreq+1);
        //     }
        // }
        // if(k==0){
        //     for(int i=0;i<input.length;i++){
        //         int freq=map.get(input[i]);
        //         if(freq>1){
        //             for(int j=0;j<(freq*(freq-1))/2;j++){
        //                 sum++;
        //             }
        //         }
        //         map.put(input[i],0);
        //     }
        // }
        // else{
        //     for(int i=0;i<input.length;i++){
        //         if(map.containsKey(input[i]+k)){
        //             int freq1=map.get(input[i]);
        //             int freq2=map.get(input[i]+k);
        //             for(int j=0;j<freq1*freq2;j++){
        //                 sum++;
        //             }
        //         }
        //         if(map.containsKey(input[i]-k)){
        //             int freq1=map.get(input[i]);
        //             int freq2=map.get(input[i]-k);
        //             for(int j=0;j<freq1*freq2;j++){
        //                 sum++;
        //             }
        //         }
        //         map.put(input[i],0);
        //     } 
        // }
        // return sum;
	}
    
}
