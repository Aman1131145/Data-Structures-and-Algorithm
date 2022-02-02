package Stack;

public class StackUse {

    public static void main(String[] args) throws StackFullException {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
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
