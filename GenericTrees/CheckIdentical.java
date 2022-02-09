package GenericTrees;
/**
 * 
 * Commented because there is one issue and it was annoying me 
 * 
 * 
 */
// package Trees;


// import java.util.ArrayList;
// import java.util.Scanner;

//  class QueueEmptyException extends Exception {
// }

//  class QueueUsingLL<T> {

// 	class TreeNode<T> {
// 		T data;
// 		TreeNode<T> next;
// 		TreeNode(T data){
// 			this.data = data;
// 		}
// 	}
	
// 	private TreeNode<T> head;
// 	private TreeNode<T> tail;
// 	private int size = 0;

// 	public int size(){
// 		return size;
// 	}

// 	public boolean isEmpty(){
// 		if(size == 0){
// 			return true;
// 		}
// 		return false;
// 	}

// 	public T front() throws QueueEmptyException{
// 		if(size == 0){
// 			QueueEmptyException e = new QueueEmptyException();
// 			throw e;
// 		}

// 		return head.data;
// 	}


// 	public void enqueue(T element){
// 		TreeNode<T> newTreeNode = new TreeNode<T>(element);

// 		if(head == null){
// 			head = newTreeNode;
// 			tail = newTreeNode;
// 		}
// 		else{
// 			tail.next = newTreeNode;
// 			tail = newTreeNode;
// 		}

// 		size++;
// 	}

// 	public T dequeue() throws QueueEmptyException{
// 		if(head == null){
// 			QueueEmptyException e = new QueueEmptyException();
// 			throw e;
// 		}
// 		if(head == tail){
// 			tail = null;
// 		}
// 		T temp = head.data;
// 		head = head.next;
// 		size--;
// 		return temp;
// 	}
// }

//    class TreeTreeNode<T> {
// 		T data;
// 		ArrayList<TreeTreeNode<T>> children;

// 		TreeTreeNode(T data){
// 			this.data = data;
// 			children = new ArrayList<TreeTreeNode<T>>();
// 		}
// 	}
 
// public class CheckIdentical {

// 	static Scanner s = new Scanner(System.in);

// 	public static TreeTreeNode<Integer> takeInputLevelWise(){
// 		QueueUsingLL<TreeTreeNode<Integer>> pendingTreeNodes = new QueueUsingLL<TreeTreeNode<Integer>>();  // Queue of TreeNode that are entered themselves but their children aren't added yet
// 		int rootData = s.nextInt();
// 		TreeTreeNode<Integer> root = new TreeTreeNode<Integer>(rootData);
// 		pendingTreeNodes.enqueue(root);
// 		while(!pendingTreeNodes.isEmpty()){
// 			TreeTreeNode<Integer> currentTreeNode;
// 			try {
// 				currentTreeNode = pendingTreeNodes.dequeue();
// 				int numChild = s.nextInt();
// 				for(int i = 0 ; i < numChild; i++){
// 					int currentChild = s.nextInt();
// 					TreeTreeNode<Integer> childTreeNode = new TreeTreeNode<Integer>(currentChild);
// 					pendingTreeNodes.enqueue(childTreeNode);
// 					currentTreeNode.children.add(childTreeNode);
// 				}
// 			} catch (QueueEmptyException e) {
// 			}
// 		}
// 		return root;
// 	}


// 	public static void main(String[] args) {
// 		TreeTreeNode<Integer> root1 =  takeInputLevelWise();
// 		TreeTreeNode<Integer> root2 = takeInputLevelWise();
// 		System.out.println(CheckIdentical.checkIdentical(root1, root2));
// 	}

//     static boolean isIdentical = true;
// 	public static boolean checkIdentical(TreeTreeNode<Integer> root1, TreeTreeNode<Integer> root2){
// 		// Write your code here

//         if(root1.children.size() != root2.children.size()){
//             return isIdentical = false;
//         }
//         for(int i = 0; i < root1.children.size(); i++){
//             checkIdentical(root1.children.get(i),root2.children.get(i));
//         }
//         return isIdentical;
// 	}

// }
