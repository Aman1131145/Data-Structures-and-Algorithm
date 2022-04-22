package DP2;

import java.io.*;

public class MagicGrid {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] takeInput() throws IOException {

        String[] nm;
        nm = br.readLine().split("\\s");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
		int arr[][]=new int[n][m];

        if (n == 0) {
            return arr;
        }
        

		String[] strNums;
        for (int i = 0; i < n; ++i) {            
            strNums = br.readLine().split("\\s");
            for (int j = 0; j < m; ++j){
                arr[i][j] = Integer.parseInt(strNums[j]);
            }
            
        }

        return arr;
    }

	public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine().trim());
        while (t!=0){
            int[][] grid = takeInput();
            System.out.println(MagicGrid.getMinimumStrength(grid));
            t--;
        }

	}

    public static int getMinimumStrength(int[][] grid) {
        // dp[i][j] represents the minimum initial grid player
        // should have so that when starts with cell(i, j) successfully
        // reaches the destination cell(m-1, n-1)
        int m = grid.length, n = grid[0].length;
        
        int dp[][] = new int[m][n];
       
        // Base case
        if(grid[m-1][n-1] > 0){
            dp[m-1][n-1] = 1;
        }else{
            dp[m-1][n-1] = Math.abs(grid[m-1][n-1]) + 1;
        }
       
        // Fill last row and last column as base to fill
        // entire table
        for (int i = m-2; i >= 0; i--){
             dp[i][n-1] = Math.max(dp[i+1][n-1] - grid[i][n-1], 1);
        }
        for (int j = n-2; j >= 0; j--){
             dp[m-1][j] = Math.max(dp[m-1][j+1] - grid[m-1][j], 1);
        }
       
        // fill the table in bottom-up fashion
        for (int i=m-2; i>=0; i--)
        {
            for (int j=n-2; j>=0; j--)
            {
                int min_grid_on_exit = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(min_grid_on_exit - grid[i][j], 1);
            }
         }
         return dp[0][0];
    }
}
