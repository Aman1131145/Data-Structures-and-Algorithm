package Recursion;

import java.util.Scanner;

public class AllIndex {

    public static int[] allIndex(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		
        return allIndex(input, x, 0);
	}
    public static int[] allIndex(int input[], int x, int startingIndex){
        if(startingIndex == input.length){
            int[] ans = new int[0];
            return ans;
        }
        int smallAns[] = allIndex(input, x, startingIndex + 1);

        if(input[startingIndex] == x){
            int Ans[] = new int[smallAns.length + 1];
            Ans[0] = startingIndex;
            for(int i = 0; i < smallAns.length + 1; i++){
                Ans[i+1] = smallAns[i];
            }
            return Ans;
        }
        else{
            return smallAns;
        }
    }
    public static int[] allIndexes(int input[], int x) {
        return allIndexes(input,x,0);

    }
    private static int[] allIndexes(int input[],int x,int startIndex){
        if(startIndex==input.length)
        {
            int output[]=new int[0];
            return output;
        }
        int smallAns[]=allIndexes(input,x,startIndex+1);
        if(input[startIndex]==x)
        {
            int answer[]=new int[smallAns.length+1];
            answer[0]=startIndex;
            for(int i=0;i<smallAns.length;i++){
              answer[i+1]=smallAns[i];
            }
             return answer;
        }
       else
           return smallAns;
    }

	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int x = s.nextInt();
		int output[] = AllIndex.allIndexes(input, x);
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}
}