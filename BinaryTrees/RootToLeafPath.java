package BinaryTrees;

import java.io.*;

public class RootToLeafPath {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingBinaryTreeNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] BinaryTreeNodeDatas = br.readLine().trim().split(" ");

		if (BinaryTreeNodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(BinaryTreeNodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingBinaryTreeNodes.enqueue(root);

		while(!pendingBinaryTreeNodes.isEmpty()){
			BinaryTreeNode<Integer> currentBinaryTreeNode;
			try {
				currentBinaryTreeNode = pendingBinaryTreeNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(BinaryTreeNodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentBinaryTreeNode.left = leftChild;
				pendingBinaryTreeNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(BinaryTreeNodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentBinaryTreeNode.right = rightChild;
				pendingBinaryTreeNodes.enqueue(rightChild);
			}
		}

		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		int k = Integer.parseInt(br.readLine().trim());

		RootToLeafPath.rootToLeafPathsSumToK(root, k);
	}

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
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
