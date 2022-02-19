package BinarySearchTrees;

import java.io.*;
import java.util.*;

public class PairSum {

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
        int sum = Integer.parseInt(br.readLine().trim());

		PairSum.pairSum(root, sum);

	}

    static ArrayList<Integer> arr = new ArrayList<>();
    static String s = "";

	static void pairSum(BinaryTreeNode<Integer> root, int sum) {

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        if(root == null){
            return;
        }
        queue.add(root);
        arr.add(root.data);
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> front = queue.remove();
            if(front.left != null){
                queue.add(front.left);
                arr.add(front.left.data);
            }
            if(front.right != null){
                queue.add(front.right);
                arr.add(front.right.data);
            }
        }
        
        for(int i = 0 ; i < arr.size()-1; i++){
            int c = sum - arr.get(i);
            if(arr.contains(c)){
                System.out.println(arr.get(i) + " " + c);
            }
        }
	}
}
