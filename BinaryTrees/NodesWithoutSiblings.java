package BinaryTrees;

import java.io.*;
import java.util.*;

class BinaryTreeBinaryTreeNode<T> {
	T data;
	BinaryTreeBinaryTreeNode<T> left;
	BinaryTreeBinaryTreeNode<T> right;

	public BinaryTreeBinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class NodesWithoutSiblings {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeBinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		Queue<BinaryTreeBinaryTreeNode<Integer>>  pendingBinaryTreeNodes = new LinkedList<BinaryTreeBinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] BinaryTreeNodeDatas = br.readLine().trim().split(" ");

		if (BinaryTreeNodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(BinaryTreeNodeDatas[start]);
		start += 1;

		BinaryTreeBinaryTreeNode<Integer> root = new BinaryTreeBinaryTreeNode<Integer>(rootData);
		pendingBinaryTreeNodes.add(root);

		while(!pendingBinaryTreeNodes.isEmpty()){
			BinaryTreeBinaryTreeNode<Integer> currentBinaryTreeNode;
			try {
				currentBinaryTreeNode = pendingBinaryTreeNodes.remove();
			} catch (Exception e) {
				return null;
			}

			int leftChildData = Integer.parseInt(BinaryTreeNodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeBinaryTreeNode<Integer> leftChild = new BinaryTreeBinaryTreeNode<Integer>(leftChildData);
				currentBinaryTreeNode.left = leftChild;
				pendingBinaryTreeNodes.add(leftChild);
			}

			int rightChildData = Integer.parseInt(BinaryTreeNodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeBinaryTreeNode<Integer> rightChild = new BinaryTreeBinaryTreeNode<Integer>(rightChildData);
				currentBinaryTreeNode.right = rightChild;
				pendingBinaryTreeNodes.remove(rightChild);
			}
		}

		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeBinaryTreeNode<Integer> root = takeInput();

		NodesWithoutSiblings.printBinaryTreeNodesWithoutSibling(root);
		
	}

    public static void printBinaryTreeNodesWithoutSibling(BinaryTreeBinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root == null){
            return;
        }
        if(root.left == null && root.right != null){
            System.out.print(root.right.data + " ");
        }
        if(root.left != null && root.right == null){
            System.out.print(root.left.data + " ");
        }
        printBinaryTreeNodesWithoutSibling(root.left);
        printBinaryTreeNodesWithoutSibling(root.right);
	}
}