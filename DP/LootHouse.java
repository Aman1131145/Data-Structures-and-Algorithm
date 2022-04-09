package DP;

import java.io.*;

public class LootHouse {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int[] takeInput() throws IOException {
		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return new int[0];
		}

		String[] strNums = br.readLine().trim().split("\\s");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strNums[i]);
        }

        return arr;
	}

    public static void main(String[] args) throws NumberFormatException, IOException {
            int[] arr = takeInput();
            System.out.println(LootHouse.maxMoneyLooted(arr));
    }

    public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        return help(houses,0);
	}
    
    public static int help(int[] house, int si){
        if(si > house.length-1){
            return 0;
        }
        
        int ans1 = house[si] + help(house, si+2); 
        int ans2 = help(house,si+1);
        
        return Math.max(ans1,ans2);
    }
}
