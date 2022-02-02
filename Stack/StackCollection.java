package Stack;

import java.util.Stack;

/**
 * StackCollection
 */
public class StackCollection {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int arr[] = {5,2,8,1};
        for(int i = 0; i < arr.length; i++){
            stack.push(arr[i]);
        }    

        while(!stack.isEmpty()){
            // int temp = stack.peek();
            // System.out.println(temp);
            System.out.println(stack.peek());
            // System.out.println(stack.pop());
        }
    }
}