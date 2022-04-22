package DP2;

import java.io.*;

public class MaximumSqurarMatrixWithAllZeros {

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

        int[][] arr = takeInput();
		System.out.println(MaximumSqurarMatrixWithAllZeros.findMaxSquareWithAllZeros(arr));
	}

    public static int findMaxSquareWithAllZeros(int[][] input){
        if(input.length == 0){
            return 0;
        }
        int n = input.length;
        int m = input[0].length;
		int[][] storage = new int[n][m];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(input[i][0] == 0){
                storage[i][0] = 1;
            }else{
                storage[i][0] = 0;
            }
            max = Math.max(storage[i][0], max);
        }

        for(int i=0;i<m;i++) {
            if(input[0][i] == 0){
                storage[0][i] = 1;
            }else{
                storage[0][i] = 0;
            }
            max = Math.max(storage[0][i], max);
        }


        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++ ) {
                if(input[i][j]==1){
					storage[i][j] = 0;
                }
                else{
                    storage[i][j] = Math.min(Math.min(storage[i-1][j-1], storage[i-1][j] ), storage[i][j-1]) + 1 ;
                }
                max = Math.max(storage[i][j], max);
            }
        }
        return max;

	}
    
}
