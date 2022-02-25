package BinarySearchTrees;

import java.util.*;
import java.io.*;

public class ReplaceWithSumOfGreaterNodes {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.remove();
			} catch (Exception e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}
		return root;
	}

	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root) throws Exception {
		if (root == null)
			return;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> first = q.remove();
			if (first == null) {
				if (q.isEmpty()) {
					break;
				}
				System.out.println();
				q.add(null);
				continue;
			}
			System.out.print(first.data + " ");
			if (first.left != null) {
				q.add(first.left);
			}
			if (first.right != null) {
				q.add(first.right);
			}
		}
	}

	public static void main(String[] args) throws IOException, Exception {
		BinaryTreeNode<Integer> root = takeInput();
		ReplaceWithSumOfGreaterNodes.replaceWithLargerNodesSum(root);
		printLevelWiseAtDiffLevel(root);
	}
    
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		// Write your code here
        replaceHelper(root,0);
	}
	public static int replaceHelper(BinaryTreeNode<Integer> root, int sum){
        if(root == null){
            return 0;
        }
        int rs = replaceHelper(root.right,sum);
        int rootdata = root.data;
        root.data += rs + sum;
        int ls = replaceHelper(root.left,root.data);
        return rootdata + rs + ls;
    }
}
