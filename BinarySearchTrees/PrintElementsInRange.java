package BinarySearchTrees;

import java.io.*;
import java.util.*;

public class PrintElementsInRange {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
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

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		st = new StringTokenizer(br.readLine());
		int k1 = Integer.parseInt(st.nextToken());
		int k2 = Integer.parseInt(st.nextToken());
		PrintElementsInRange.elementsInRangeK1K2(root, k1, k2);
	}

    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
        if(root == null){
            return;
        }
        elementsInRangeK1K2(root.left,k1,k2);
        if(root.data <= k2 && root.data >= k1){
            System.out.print(root.data + " ");
        }
        elementsInRangeK1K2(root.right,k1,k2);
    }

}
