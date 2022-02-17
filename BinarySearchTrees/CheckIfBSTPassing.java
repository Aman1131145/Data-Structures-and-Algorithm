package BinarySearchTrees;


import java.io.*;
import java.util.*;

public class CheckIfBSTPassing {

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

        boolean ans = CheckIfBSTPassing.isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
        System.out.println(ans);

	}

    private static boolean isBST(BinaryTreeNode<Integer> root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        boolean isLeftOk = isBST(root.left, min, root.data - 1);
        boolean isRightOk = isBST(root.right, root.data, max);
        return isLeftOk && isRightOk;
    }
    
}
