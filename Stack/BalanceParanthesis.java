package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalanceParanthesis {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(BalanceParanthesis.isBalanced(expression));
    }

    public static boolean isBalanced(String expression) {
        //Your code goes here
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i)=='('){
                stack.push(expression.charAt(i));
            }
            if(expression.charAt(i)==')'){
                if(stack.size() == 0){
                    return false;
                }
                else{
                    if(stack.peek()=='('){
                        stack.pop();
                    }
                }
            }                    
        }
        return stack.isEmpty();
    }
}