package Test3;

import java.util.*;

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}
public class CheckCousins {
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
		System.out.println(CheckCousins.isCousin(root, p, q));
	}

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
		return !helper(root, p, q) && level(root, 0, p) == level(root, 0, q);
	}

	public static boolean helper(BinaryTreeNode<Integer> root,int p,int q) {
		if(root==null) {
			return false;
		}
		if(root.left!=null && root.right!=null) {
			
			if(root.left.data == p && root.right.data == q) {
				return true;
			}
		}
		return helper(root.left, p, q) || helper(root.right, p, q);
	}
	
	public static int level(BinaryTreeNode<Integer> root,int k,int p) {
		if(root==null)
			return -1;
		if(root.data == p) {
			return k;
		}
		int left  = level(root.left, k+1, p);
		int right = level(root.right, k+1, p);
		if(left==-1) {
			return right;
		}
		if(right==-1) {
			return left;
		}
		return -1;
	}
}