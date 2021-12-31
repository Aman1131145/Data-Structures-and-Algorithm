package Recursion;

public class GeomatricSum {

    public static double geomatricSum(double n){
        if(n <= 0){
            return 1;
        }
        return 1/power(n) + geomatricSum(n-1) ;
    }
    public static double power(double n){
        if(n == 0){
            return 1;
        }
        return 2 * power(n-1);
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(geomatricSum(n));
    }
}
