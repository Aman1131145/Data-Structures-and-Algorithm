package Recursion;

// import java.util.Scanner;

public class Sum {

    public static int sum(int input[]){
        if(input.length == 0){
            return 0;
        }
        if(input.length == 1){
            return input[0];
        }

        int smallInput[] = new int[input.length-1];
        for(int i = 1; i <= input.length - 1; i++){
            smallInput[i-1] = input[i];
        }

        return input[0] + sum(smallInput);
    }
    
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // int n = s.nextInt();
	    int input[] = {1,2,3,4,5,6,7,8,9,10};
	    // for(int i = 0; i < n; i++) {
		//     input[i] = s.nextInt();
	    // }
	    System.out.println(Sum.sum(input)); 
        // s.close();
    }
      
}
