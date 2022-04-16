package DP2;

import java.io.*;

/**
 * LootHouse
 */
public class LootHouse {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        if(houses.length == 0){
            return 0;
        }
        int n = houses.length;
        int storage[] = new int[n];
        
        storage[0] = houses[0];
        storage[1] = Math.max(houses[0], houses[1]);
        
        for(int i = 2; i <= n-1; i++){
            storage[i] = Math.max(houses[i] + storage[i-2], storage[i-1]);
        }
        return storage[n-1];
	}
	
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
}