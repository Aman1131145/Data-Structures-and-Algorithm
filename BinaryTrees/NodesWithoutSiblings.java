package BinaryTrees;

import java.io.*;
import java.util.*;

public class NodesWithoutSiblings {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		Queue<BinaryTreeNode<Integer>>  pendingBinaryTreeNodes = new LinkedList<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] BinaryTreeNodeDatas = br.readLine().trim().split(" ");

		if (BinaryTreeNodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(BinaryTreeNodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingBinaryTreeNodes.add(root);

		while(!pendingBinaryTreeNodes.isEmpty()){
			BinaryTreeNode<Integer> currentBinaryTreeNode;
			try {
				currentBinaryTreeNode = pendingBinaryTreeNodes.remove();
			} catch (Exception e) {
				return null;
			}

			int leftChildData = Integer.parseInt(BinaryTreeNodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentBinaryTreeNode.left = leftChild;
				pendingBinaryTreeNodes.add(leftChild);
			}

			int rightChildData = Integer.parseInt(BinaryTreeNodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentBinaryTreeNode.right = rightChild;
				pendingBinaryTreeNodes.remove(rightChild);
			}
		}

		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();

		NodesWithoutSiblings.printBinaryTreeNodesWithoutSibling(root);
		
	}

    public static void printBinaryTreeNodesWithoutSibling(BinaryTreeNode<Integer> root) {
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