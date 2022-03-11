package Maps;

import java.io.*;
import java.util.*;

public class LongestSubsetZero {
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
		System.out.println(LongestSubsetZero.lengthOfLongestSubsetWithZeroSum(arr));
	}

    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		// Write your code here
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (len < i + 1) {
                    len = i + 1;
                }
            }
            else if (map.containsKey(arr[i])) {
                if (len < i - map.get(arr[i])) {
                    len = i - map.get(arr[i]);
                }
            }
            else {
                map.put(arr[i],i);
            }
        }
        return len;
//         if(arr.length==0)
//             return 0;
//         HashMap<Integer,Integer> h=new HashMap<>();
//         int sum=0;
//         int maxlength=0;
//         int maxlength1=0;
//         for(int i=0;i<arr.length;i++)
//         {
//             sum=sum+arr[i];
//             if(h.containsKey(sum)){
//                 int k=h.get(sum);
//                 int l=i-k;
//                 maxlength1=l;}
//              // if(!h.containsKey(sum))
//             else
//             h.put(sum,i);
//             if(sum==0)
//             {
//                 maxlength1=i+1;
//             }
           
//             if(maxlength1>maxlength)
//                 maxlength=maxlength1;
//         }
// 		return maxlength;
	}
    
}
