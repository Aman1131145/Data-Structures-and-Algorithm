package DP2;

import java.io.*;

public class SmallestSuperSequence {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException  {
		String str1 = br.readLine();
		String str2 = br.readLine();
		int min_len = SmallestSuperSequence.smallestSuperSequence(str1, str2);
		System.out.print(min_len);
	}

    public static int smallestSuperSequence(String X, String Y) {
		int m = X.length(), n = Y.length();
 
        
        int[][] T = new int[m + 1][n + 1];
 
        // initialize the first column of the lookup table
        for (int i = 0; i <= m; i++) {
            T[i][0] = i;
        }
 
        // initialize the first row of the lookup table
        for (int j = 0; j <= n; j++) {
            T[0][j] = j;
        }
 
        // fill the lookup table in a bottom-up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if the current character of `X` and `Y` matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }
                // otherwise, if the current character of `X` and `Y` don't match
                else {
                    T[i][j] = Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1);
                }
            }
        }
 
        // SCS will be the last entry in the lookup table
        return T[m][n];
    }
    
}
