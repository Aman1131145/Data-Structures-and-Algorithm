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
        return minInitialPoints(grid,grid.length,grid[0].length);
    }
    
    static int minInitialPoints(int points[][],int R,int C)
    {
        // dp[i][j] represents the minimum initial points player
        // should have so that when starts with cell(i, j) successfully
        // reaches the destination cell(m-1, n-1)
        int dp[][] = new int[R][C];
        int m = R, n = C;
       
        // Base case
        dp[m-1][n-1] = points[m-1][n-1] > 0? 1:
                       Math.abs(points[m-1][n-1]) + 1;
       
        // Fill last row and last column as base to fill
        // entire table
        for (int i = m-2; i >= 0; i--)
             dp[i][n-1] = Math.max(dp[i+1][n-1] - points[i][n-1], 1);
        for (int j = n-2; j >= 0; j--)
             dp[m-1][j] = Math.max(dp[m-1][j+1] - points[m-1][j], 1);
       
        // fill the table in bottom-up fashion
        for (int i=m-2; i>=0; i--)
        {
            for (int j=n-2; j>=0; j--)
            {
                int min_points_on_exit = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(min_points_on_exit - points[i][j], 1);
            }
         }
       
         return dp[0][0];
    }
}
