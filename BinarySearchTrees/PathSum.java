package BinarySearchTrees;

import java.io.*;
import java.util.*;

public class PathSum {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new LinkedList<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.remove();
			} catch (Exception e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}

		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		int k = Integer.parseInt(br.readLine().trim());

		PathSum.rootToLeafPathsSumToK(root, k);
	}

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		//Your code goes here
        String string = "";
		print(root,k,string);        
	}
    
    public static void print(BinaryTreeNode<Integer> root, int k, String string){
        if(root == null){
            return;
        }
        if(root.data == k){
        	if(root.left == null && root.right == null){
                string += root.data + " ";
                System.out.println(string);
            }
            return;
        }
        string += root.data + " ";
        
        print(root.left,k-root.data,string);
        print(root.right,k-root.data,string);
    }
}
