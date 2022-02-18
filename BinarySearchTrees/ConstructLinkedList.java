package BinarySearchTrees;

import java.io.*;
import java.util.*;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}

public class ConstructLinkedList {

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
		LinkedListNode<Integer> head = ConstructLinkedList.constructLinkedList(root);
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

    static class pair{
        LinkedListNode<Integer> head;
        LinkedListNode<Integer> tail;
    }
    
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        pair ans = helper(root);
        return ans.head;
	}
    
    private static pair helper(BinaryTreeNode<Integer> root){
        if(root==null){
            pair output = new pair();
            output.head = null;
            output.tail = null;
            return output;
        }
        pair lefttree = helper(root.left);
        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);
        pair righttree = helper(root.right);
        pair output = new pair();
        if(lefttree.head != null){
            output.head = lefttree.head;
            lefttree.tail.next = newNode;
        }else{
            output.head = newNode;
        }
    	newNode.next = righttree.head;
        if(righttree.head == null){
            output.tail = newNode;
        }else{
            output.tail = righttree.tail;
        }
        return output;
    }

}
