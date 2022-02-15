package BinarySearchTrees;

import java.io.*;
import java.util.*;

public class CheckIfBST {

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
			} catch ( Exception e) {
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

        boolean ans = CheckIfBST.isBST(root);
        
        System.out.println(ans);

	}
    public static int maximumLeft(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data , Math.max(maximumLeft(root.left) ,maximumLeft(root.right)));
    }
    

    public static int minimumRight(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data , Math.min(minimumRight(root.left) ,minimumRight(root.right)));
    }
    
	public static boolean isBST(BinaryTreeNode<Integer> root) {
        if(root==null){
        	return true;
        }
        int maxLeft = maximumLeft(root.left);
        int minRight = minimumRight(root.right);
         
        if(root.data <= maxLeft){
            return false;
        }
        if (root.data > minRight){
            return false;
        }
        boolean isLeftOk = isBST(root.left);
        boolean isRightOk =isBST(root.right);
        
        if (isRightOk && isLeftOk){
            return true;
        }else{
            return false;
        }
	}
}