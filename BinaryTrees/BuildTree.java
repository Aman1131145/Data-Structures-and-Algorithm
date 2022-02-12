package BinaryTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class PairBuild {
	int[] preOrder;
	int[] inOrder;

	public PairBuild(int[] preOrder, int[] inOrder) {
		this.preOrder = preOrder;
		this.inOrder = inOrder;
	}

}

public class BuildTree {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static PairBuild takeInput() throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine().trim());

    	int pre[] = new int[n];
    	int in[] = new int[n];

    	String[] preOrder = br.readLine().trim().split(" ");
    	String[] inOrder = br.readLine().trim().split(" ");


    	for (int i = 0; i < n; i++) {
    		pre[i] = Integer.parseInt(preOrder[i].trim());
    		in[i] = Integer.parseInt(inOrder[i].trim());
    	}

    	return new PairBuild(pre, in);

    }

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
        pendingNodes.add(null);

		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

        
	        if (frontNode == null) {
	            System.out.println();

	            if (!pendingNodes.isEmpty()) {
	                pendingNodes.add(null);
	            }

	        } else {
	        	System.out.print(frontNode.data + " ");

	            if (frontNode.left != null) {
	                pendingNodes.add(frontNode.left);
	            } 

	            if (frontNode.right != null) {
	                pendingNodes.add(frontNode.right);
	            } 
	        }

		}
		
	}
    public static void main(String[] args) throws NumberFormatException, IOException {

    	PairBuild input = takeInput();

    	int[] preOrder = input.preOrder;
    	int[] inOrder = input.inOrder;

    	BinaryTreeNode<Integer> root = BuildTree.buildTree(preOrder, inOrder);
		
    	printLevelWise(root);
		
    }
	
	public static BinaryTreeNode<Integer> buildTree(int in[], int pre[]) {
		return buildTreeHelper(in, pre, 0, in.length - 1, 0, pre.length -1);
	}
	
    public static BinaryTreeNode<Integer> buildTreeHelper(int in[], int pre[], int inS, int inE, int preS, int preE) {
		if (inS > inE) {
			return null;
		}
		int rootData = pre[preS];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int rootInIndex = -1;
		for (int i = inS; i <= inE; i++) {
			if (in[i] == rootData) {
				rootInIndex = i;
				break;
			}
		}
		if (rootInIndex == -1) {
			return null;
		}
		
		int leftInS = inS;
		int leftInE = rootInIndex - 1;
		int leftPreS = preS + 1;
		int leftPreE = leftInE - leftInS + leftPreS;
		int rightInS = rootInIndex + 1;
		int rightInE = inE;
		int rightPreS = leftPreE + 1;
		int rightPreE = preE;
		root.left = buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
		root.right = buildTreeHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);
		return root;
	}
	
}
