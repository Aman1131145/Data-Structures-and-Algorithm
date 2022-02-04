package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws NumberFormatException, IOException {
    	int size = Integer.parseInt(br.readLine().trim());
    	int[] input = new int[size];

    	if (size == 0) {
    		return input;
    	}

    	String[] values = br.readLine().trim().split(" ");

    	for(int i = 0; i < size; i++) {
    		input[i] = Integer.parseInt(values[i]);
    	}

    	return input;
    }

    public static void printArray(int[] arr) {
    	for (int i = 0 ; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}

    	System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    	int[] input = takeInput();

    	int[] output = StockSpan.stockSpan(input);

    	printArray(output);

    }

    public static int[] stockSpan(int[] price) {
		//Your code goes here
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[price.length];
        for(int i = 0; i < price.length; i++){
            int count = 1;
            if(stack.isEmpty()){
                stack.push(i);
                result[i] = count;
            }else if(price[stack.peek()] < price[i]){
                while(!stack.isEmpty() && price[stack.peek()] < price[i]){
                    count += result[stack.pop()];
                }
                stack.push(i);
                result[i] = count;
            }else{
                stack.push(i);
                result[i] = count;
            }
        }
        return result;
	}
}