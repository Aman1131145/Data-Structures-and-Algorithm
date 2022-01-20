package Test1;

import java.util.Arrays;
import java.util.Scanner;

public class MaxProfit {

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//
        int n = s.nextInt();
		int budget[] = new int[n];
		for(int i=0;i<n;i++)
			budget[i] = s.nextInt();
		
		System.out.println(MaxProfit.maximumProfit(budget));
        s.close();
	}

    public static int maximumProfit(int[] budget) {
        return maxProfit(budget, 0, budget.length - 1);
	}
    private static int maxProfit(int price[], int start, int end){
 
    	if (end <= start){
        	return 0;
        }
     
    	int profit = 0;
    	for (int i = start; i < end; i++)
    	{
         	for (int j = i + 1; j <= end; j++)
         	{
             	if (price[j] > price[i])
             	{            
                	int curr_profit = price[j] - price[i]
                                + maxProfit(price, start, i - 1)
                                + maxProfit(price, j + 1, end);
                 	profit = Math.max(profit, curr_profit);
             	}
         	}
    	}
    	return profit;
	}

    
    
}
