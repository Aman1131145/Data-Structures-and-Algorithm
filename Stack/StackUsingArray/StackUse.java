package Stack.StackUsingArray;

public class StackUse {

    public static void main(String[] args) throws StackFullException {
        StackUsingArray stack = new StackUsingArray(3);
        for(int i = 1; i <= 5; i++){
            stack.push(i);
        }
        while(!stack.isEmpty()){
            try{
                System.out.print(stack.pop() + " ");
            }catch (StackEmptyException e){
            //never reach here
            }
        }
    }
}
