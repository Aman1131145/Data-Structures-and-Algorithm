package Stack;

public class StackUsingLinkedList<T> {

	private StackNode<T> head;
	private int size;

	public StackUsingLinkedList(){
		head = null;
		size = 0;
	}

	int size(){
		return size;
	}

	boolean isEmpty(){
		return size() == 0; // head == null;
	}

	T top() throws StackEmptyException{
		if(size() == 0){
			// StackEmptyException e = new StackEmptyException();
			// throw e;
			throw new StackEmptyException();
		}
		return head.data;
	}

	void push(T element){
		StackNode<T> newNode = new StackNode<T>(element);
		newNode.next = head;
		head = newNode;
		size++;
	}

	T pop() throws StackEmptyException{
		if(size() == 0){
			throw new StackEmptyException();
		}
		T tempdata = head.data;
		head = head.next;
		return tempdata;
	}
    
}
