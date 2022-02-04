package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumBracketReversal {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

    	System.out.println(MinimumBracketReversal.countBracketReversals(br.readLine().trim()));

    }
    public static int countBracketReversals(String input) {
		//Your code goes here
        if(input.length()%2 == 1){
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '{'){
                stack.push(input.charAt(i));
            }else{
                if(stack.isEmpty()){
                    stack.push(input.charAt(i));
                }else if(stack.peek() == '}'){
                    stack.push(input.charAt(i));
                }
                if(stack.peek() == '{'){
                    stack.pop();
                }
            }
        }
        int count = 0;
        while(!stack.isEmpty()){
            char c1 = stack.pop();
            char c2 = stack.pop();
            if(c1 == c2){
                count++;
            }else{
                count += 2;
            }
        }
        return count;
	}
}