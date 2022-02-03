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

    // public static boolean isBalanced(String expression) {
    //     //Your code goes here
    //     Stack<String> stack = new Stack<>();
    //     String p = null;
    //     for(int i = 0; i < expression.length(); i++){
    //         String c = expression.substring(i,i+1);
    //         if((c.contains("}") || c.contains(")") || c.contains("]")) && stack.size() == 0){
    //             return false;
    //         }
    //         if(c.contains("{") || c.contains("(") || c.contains("[")){
    //             stack.push(c);
    //             p = stack.peek();
    //         }
    //         if((c.contains(")") && p.contains("(")) || (c.contains("}") && p.contains("{")) || c.contains("]") && p.contains("[")){
	// 			stack.pop();
    //         }         
    //     }
    //     return stack.isEmpty();
    // }

    public static boolean isBalanced(String expression) {
        //Your code goes here
        Stack<String> stack=new Stack<>();
        String temp=expression;
        int i=0;
        while(i<temp.length()){
            if(temp.charAt(i)=='[' || temp.charAt(i)=='{' || temp.charAt(i)=='(' ){
                stack.push(temp.charAt(i));
            }
            // if get closing bracket
            else if(temp.charAt(i)==']' || temp.charAt(i)=='}' || temp.charAt(i)==')'){
                if(stack.isEmpty())
                    return false;
                else if(!matchPair((char)stack.pop(),temp.charAt(i)))
                    return false;
            }
            i++;
        }
        if(stack.isEmpty())
            return true;
        else 
            return false;

	}
    public static boolean matchPair(char par1,char par2){
        if(par1=='{' && par2=='}')
            return true;
        else if(par1=='(' && par2==')')
            return true;
        else if(par1=='[' && par2==']')
            return true;
        else
            return false;
    }
}
