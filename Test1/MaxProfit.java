package Test1;

import java.util.Arrays;

public class MaxProfit {

	public static int maximumProfit(int budget[]) {
		// Write your code here
       	Arrays.sort(budget);
        int n=budget.length;
		int x=budget[0];
        int max=n*x;
        for(int i=0;i<n;i++)
        {
            x=budget[i];
            int temp=(n-i)*x;
            if(temp>max){
                max=temp;
            }
        }
        return max;
	}
}
