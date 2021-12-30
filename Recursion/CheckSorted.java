package Recursion;

public class CheckSorted {

    public static boolean checkSorted(int input[]){
        if(input.length <= 1){
            return true;
        }

        int smallInput[] = new int[input.length - 1];
        for(int i = 1; i < input.length; i++){
            smallInput[i-1] = input[i];
        }

        boolean smallAns = checkSorted(smallInput);
        if(!smallAns){
            return false;
        }
        if(input[0] <= input[1]){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkSorted2(int input[]){
        if(input.length <= 1){
            return true;
        }
        if(input[0] > input[1]){
            return false;
        }

        int smallInput[] = new int[input.length - 1];
        for(int i = 1; i < input.length; i++){
            smallInput[i-1] = input[i];
        }

        boolean smallAns = checkSorted2(smallInput);
        return smallAns;
        }
    
    
    public static void main(String[] args) {
        int input[] = {2,1,3,6,9};
        System.out.println(checkSorted(input));
    }
}
