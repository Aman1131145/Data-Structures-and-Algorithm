package Trees;


import java.util.ArrayList;
import java.util.Scanner;

 class QueueEmptyException extends Exception {
}

 class QueueUsingLL<T> {

	class TreeNode<T> {
		T data;
		TreeNode<T> next;
		TreeNode(T data){
			this.data = data;
		}
	}

	private TreeNode<T> head;
	private TreeNode<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		TreeNode<T> newTreeNode = new TreeNode<T>(element);

		if(head == null){
			head = newTreeNode;
			tail = newTreeNode;
		}
		else{
			tail.next = newTreeNode;
			tail = newTreeNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

   class TreeTreeNode<T> {
		T data;
		ArrayList<TreeTreeNode<T>> children;

		TreeTreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeTreeNode<T>>();
		}
	}

public class CheckX {



	static Scanner s = new Scanner(System.in);

	public static TreeTreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeTreeNode<Integer>> pendingTreeNodes = new QueueUsingLL<TreeTreeNode<Integer>>();  // Queue of TreeNodes that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeTreeNode<Integer> root = new TreeTreeNode<Integer>(rootData);
		pendingTreeNodes.enqueue(root);
		while(!pendingTreeNodes.isEmpty()){
			TreeTreeNode<Integer> currentTreeNode;
			try {
				currentTreeNode = pendingTreeNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeTreeNode<Integer> childTreeNode = new TreeTreeNode<Integer>(currentChild);
					pendingTreeNodes.enqueue(childTreeNode);
					currentTreeNode.children.add(childTreeNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}


	public static void main(String[] args) {


		int x = s.nextInt();
    TreeTreeNode<Integer> root =  takeInputLevelWise();
		System.out.println(CheckX.checkIfContainsX(root, x));

	}

    static boolean isPresent = false;
	public static boolean checkIfContainsX(TreeTreeNode<Integer> root, int x){

		// Write your code here
        if(root == null){
            return false;
        }
        if(root.data == x){
            isPresent = true;
        }
        for(int i = 0; i < root.children.size(); i++){
            checkIfContainsX(root.children.get(i),x);
        }
        return isPresent;
    }
}

