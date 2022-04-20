package DP2;

public class Knapsack {

    public static int knapsack(int[] weights, int values[],int n, int maxWeight){
        if(n == 0 || maxWeight == 0){
            return 0;
        }
        if(weights[n-1] > maxWeight){
            return knapsack(weights, values, n-1, maxWeight);
        }else{
            int op1 = values[n-1] + knapsack(weights, values, n-1, maxWeight - weights[n-1]);
            int op2 = knapsack(weights, values, n-1, maxWeight);
            return Math.max(op1, op2);
        }
    }

    public static int knapsackDP(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[2][maxWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= maxWeight; ++j) {
                if (weight[i] <= j) {
                    dp[i % 2][j] = Math.max(value[i] + dp[(1 + i) % 2][j - weight[i]],
                    dp[(i + 1) % 2][j]);
                } else {
                    dp[i % 2][j] = dp[(i + 1) % 2][j];
                }
            }
        }
        return dp[(n + 1) % 2][maxWeight];
    }

    public static void main(String[] args) {
        int weights[] = {1,2,3,8,7,4};
        int values[] = {20,5,10,40,15,25};
        int maxWeight = 10;
        System.out.println(knapsackDP(weights, values, weights.length-1, maxWeight));
        System.out.println(knapsack(weights, values, weights.length-1, maxWeight));
    }
    
}
