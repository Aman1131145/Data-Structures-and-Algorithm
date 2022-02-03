package Stack;

import java.util.Stack;

/**
 * StackCollection
 */
public class StackCollection {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<10;i++)
        {
            stack.push(i*2);
        }
        System.out.print(stack.peek());
        // stack.push(5);
        // stack.push(10);
        // stack.push(15);
        // System.out.print(stack.pop()+stack.size());
        // int arr[] = {5,2,8,1};
        // for(int i = 0; i < arr.length; i++){
        //     stack.push(arr[i]);
        // }    

        // while(!stack.isEmpty()){
        //     // int temp = stack.peek();
        //     // System.out.println(temp);
        //     System.out.println(stack.peek());
        //     // System.out.println(stack.pop());
        // }
    }
}