package Recursion;
import java.util.Scanner;

public class Power {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

        int x = s.nextInt();
		int n = s.nextInt();
		
		System.out.println(Solution.power(x, n));
	}
    class Solution {

        public static int power(int x, int n) {
            /* Your class should be named Solution
             * Don't write main().
             * Don't read input, it is passed as function argument.
             * Return output and don't print it.
             * Taking input and printing output is handled automatically.
             */
            if(n == 0){
                return 1;
            }
            return x * power(x,n-1);
        }
    }
}
