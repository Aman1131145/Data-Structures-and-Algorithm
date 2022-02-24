package BinarySearchTrees;

import java.util.*;
import java.io.*;

class bstSubtreeReturn {
    int max;
    int min;
    int height;
    boolean isBST;
}
public class LargestBST {

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
	
	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		System.out.println(LargestBST.largestBSTSubtree(root));
	}

    public static bstSubtreeReturn largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            bstSubtreeReturn ans = new bstSubtreeReturn();
            ans.max = Integer.MIN_VALUE;
            ans.min = Integer.MAX_VALUE;
            ans.isBST = true;
            ans.height = 0;
            return ans;
        }
        bstSubtreeReturn left = largestBSTSubtreeHelper(root.left);
        bstSubtreeReturn right = largestBSTSubtreeHelper(root.right);
        if (!(right.isBST && right.min > root.data)) {
            right.isBST = false;
        }
        if (!(left.isBST && left.max < root.data)) {
            left.isBST = false;
        }
        bstSubtreeReturn ans = new bstSubtreeReturn();
        if (!left.isBST || !right.isBST || root.data < left.max || root.data > right.min) {
            if (left.height > right.height) {
                left.isBST = false;
                return left;
            } else {
                right.isBST = false;
                return right;
            }
        }
        ans.isBST = true;
        ans.min = Math.min(left.min, Math.min(right.min, root.data));
        ans.max = Math.max(left.max, Math.max(right.max, root.data));
        ans.height = Math.max(left.height, right.height) + 1;
        return ans;
    }
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return largestBSTSubtreeHelper(root).height;
    }
}