package BinaryTrees;

import java.io.*;

public class PrintNodesAtK {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}

		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		String[] target_k = br.readLine().trim().split(" ");

		int target = Integer.parseInt(target_k[0].trim());
		int k = Integer.parseInt(target_k[1].trim());

		PrintNodesAtK.nodesAtDistanceK(root, target, k);
	}

    private static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int target, int k) {
        print(root,target,k);
    }
    private static int print(BinaryTreeNode<Integer> root, int elem, int k) {
        if(root == null){
            return -1;
        }
        if(root.data == elem){
            printAtDepthK(root,k);
            return 0;
        }
        int ld = print(root.left, elem, k);
        int rd;

        if(ld == -1){
            rd = print(root.right, elem, k);
            if(rd == -1){
                return -1;
            }else if (rd+1== k) {
                System.out.println(root.data);
                return k;
            } else {
                printAtDepthK(root.left, k-rd-2);
                return rd+1;
            }
        } else if (ld+1==k) {
            System.out.println(root.data);
            return k;
        } else {
            printAtDepthK(root.right, k-ld-2);
            return ld+1;
        }
    }
    public static void printAtDepthK(BinaryTreeNode<Integer> root,int depth){
        if(root == null){
            return;
        }
        if(depth == 0 && root != null){
            System.out.println(root.data);
            return;
        }
        printAtDepthK(root.left,depth-1);
        printAtDepthK(root.right,depth-1);
    }
}