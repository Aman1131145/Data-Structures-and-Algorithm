package GenericTrees;
/**
 * 
 * 
 * Commented because there is one issue that was annoying me
 * 
 * 
 */

// package Trees;

// import java.util.ArrayList;
// import java.util.Scanner;

//  class QueueEmptyException extends Exception {
// }

//  class QueueUsingLL<T> {

// 	class Node<T> {
// 		T data;
// 		Node<T> next;
// 		Node(T data){
// 			this.data = data;
// 		}
// 	}
	
// 	private Node<T> head;
// 	private Node<T> tail;
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
// 		Node<T> newNode = new Node<T>(element);

// 		if(head == null){
// 			head = newNode;
// 			tail = newNode;
// 		}
// 		else{
// 			tail.next = newNode;
// 			tail = newNode;
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

//    class TreeNode<T> {
// 		T data;
// 		ArrayList<TreeNode<T>> children;

// 		TreeNode(T data){
// 			this.data = data;
// 			children = new ArrayList<TreeNode<T>>();
// 		}
// 	}
 
// public class MaximumSumNode {

	

// 	static Scanner s = new Scanner(System.in);

// 		public static TreeNode<Integer> takeInputLevelWise(){
// 		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
// //		System.out.println("Enter root Data");
// 		int rootData = s.nextInt();
// 		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
// 		pendingNodes.enqueue(root);
// 		while(!pendingNodes.isEmpty()){
// 			TreeNode<Integer> currentNode;
// 			try {
// 				currentNode = pendingNodes.dequeue();
// //				System.out.println("Enter number of children of "+currentNode.data);
// 				int numChild = s.nextInt();
// 				for(int i = 0 ; i < numChild; i++){
// //					System.out.println("Enter "+ i + "th child of " + currentNode.data);
// 					int currentChild = s.nextInt();
// 					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
// 					pendingNodes.enqueue(childNode);
// 					currentNode.children.add(childNode);
// 				}
// 			} catch (QueueEmptyException e) {
// 			}
// 		}
// 		return root;
// 	}

// 	public static void main(String[] args) {
// 		TreeNode<Integer> root =  takeInputLevelWise();
// 		TreeNode<Integer> ans = MaximumSumNode.maxSumNode(root);
// 		if(ans == null){
// 			System.out.println(Integer.MIN_VALUE);
// 		}else{
// 			System.out.println(ans.data);
// 		}
		
// 	}

//     static int largestSum = 0;
//     static TreeNode<Integer> largestSumNode = null;
// 	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
// 		// Write your code here
//         if(root == null){
//             return null;
//         }
//         for(int i = 0; i < root.children.size(); i++){
//             maxSumNode(root.children.get(i));
//         }
//         int treeSum = root.data;
//         for(int i = 0; i < root.children.size(); i++){
//             treeSum += root.children.get(i).data;
//         }
//         if(treeSum > largestSum){
//             largestSum = treeSum;
//             largestSumNode = root;
//         }
//         return largestSumNode;
// 	}

// }

