package BinarySearchTrees;

import java.io.*;
import java.util.*;

class pair<T,V> {
    public T first;
    public V second;
}

public class CheckIfBSTBetter {

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

        boolean ans = CheckIfBSTBetter.isBSTBetter(root).first;
        
        System.out.println(ans);

	}
 
    public static pair<Boolean, pair<Integer,Integer>> isBSTBetter(BinaryTreeNode<Integer> root){
        if(root == null){
            pair<Boolean,pair<Integer,Integer>> output = new pair<>();
            output.first = true;
            output.second = new pair<>();
            output.second.first = Integer.MAX_VALUE;
            output.second.second = Integer.MIN_VALUE;
            return output;
        }
        pair<Boolean,pair<Integer,Integer>> leftOutput = isBSTBetter(root.left);
        pair<Boolean,pair<Integer,Integer>> rightOutput = isBSTBetter(root.right);
        int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
        int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
        boolean isBST = (root.data > leftOutput.second.second) 
						&& (root.data <= rightOutput.second.first) 
						&& leftOutput.first && rightOutput.first;
        
        pair<Boolean,pair<Integer,Integer>> output = new pair<>();
        output.first = isBST;
        output.second = new pair<>();
        output.second.first = min;
        output.second.second = max;
        return output;
    }
}