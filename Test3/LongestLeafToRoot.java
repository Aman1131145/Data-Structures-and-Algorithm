package Test3;
import java.util.*;

class Node<T> {
	T data;
	Node<T> next;
	Node(T data){
		this.data = data;
	}
}

public class LongestLeafToRoot {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new LinkedList<BinaryTreeNode<Integer>>(); 
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.remove();
			} catch (Exception e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		int p = s.nextInt();
		int q = s.nextInt();
		System.out.println(LongestLeafToRoot.isCousin(root, p, q));
	}

    public static boolean isCousin(BinaryTreeNode<Integer> root, int node1, int node2) {
		return !isSiblings(root, node1, node2) && level(root, 0, node1) == level(root, 0, node2);
	}
	public static boolean isSiblings(BinaryTreeNode<Integer> root,int node1,int node2) {

		if(root==null) {
			return false;
		}
		if(root.left!=null && root.right!=null) {
			
			if(root.left.data == node1 && root.right.data == node2) {
				return true;
			}
			
		}
		return isSiblings(root.left, node1, node2) || isSiblings(root.right, node1, node2);
		
	}
	public static int level(BinaryTreeNode<Integer> root,int k,int node1) {

		if(root==null)
			return -1;
		if(root.data == node1) {
			return k;
		}
		int left  = level(root.left, k+1, node1);
		int right = level(root.right, k+1, node1);
		if(left==-1) {
			return right;
		}
		if(right==-1) {
			return left;
		}
		return -1;
		
	}
}