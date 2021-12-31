package Recursion;

public class CheckIfPresent {

    public static boolean checkIfPresent(int input[],int x){
        if(input.length == 0){
            return false;
        }
        
        if(input[0] == x){
            return true;
        }

        int smallInput[] = new int[input.length - 1];
        for(int i = 1; i < input.length; i++){
            smallInput[i-1] = input[i];
        }

        boolean smallAns = checkIfPresent(smallInput,x);
        return smallAns;
        
    }
    public static void main(String[] args) {
        int input[] = {4,8,1,2,4,5};
        int x = 6;
        System.out.println(CheckIfPresent.checkIfPresent(input,x));
    }
    
}
