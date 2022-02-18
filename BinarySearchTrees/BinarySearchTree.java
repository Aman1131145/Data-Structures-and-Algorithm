package BinarySearchTrees;

import java.util.*;
import java.io.*;

public class BinarySearchTree {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			choice = Integer.parseInt(st.nextToken());
			switch (choice) {
			case 1:
				input = Integer.parseInt(st.nextToken());
				bst.insert(input);
				break;
			case 2:
				input = Integer.parseInt(st.nextToken());
				bst.remove(input);
				break;
			case 3:
				input = Integer.parseInt(st.nextToken());
				System.out.println(bst.search(input));
				break;
			default:
				bst.printTree();
				break;
			}

		}
	}
	
    BinaryTreeNode<Integer> root;
	
	public void insert(int data) {
		root = insert(data, root);
	}
	
	private BinaryTreeNode<Integer> insert(int data, BinaryTreeNode<Integer> root) {
		if (root == null) {
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
			return newNode;
		}
		if (root.data >= data) {
			root.left = insert(data, root.left);
		} 
		else {
			root.right = insert(data, root.right);
		}
		return root;
	}

	public void remove(int data) {
		root = remove(data, root);
	}

	private BinaryTreeNode<Integer> remove(int data, BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (data < root.data) {
			root.left = remove(data, root.left);
			return root;
		} 
		else if (data > root.data) {
			root.right = remove(data, root.right);
			return root;
		} 
		else {
			if (root.left == null && root.right == null) {
				return null;
			} 
			else if (root.left == null) {
				return root.right;
			} 
			else if (root.right == null) {
				return root.left;
			} 
			else {
				BinaryTreeNode<Integer> minNode = root.right;
				while (minNode.left != null) {
					minNode = minNode.left;
				}
				root.data = minNode.data;
				root.right = remove(minNode.data, root.right);
				return root;
			}
		}
	}
	
	
    public boolean search(int data){
		return searchHelper(data, root);
    }
    
    private boolean searchHelper(int data, BinaryTreeNode<Integer> root){
		if(root == null){
			return false;
        }
        if(root.data == data){
			return true;
        }else if(data > root.data){
			// call right
            return searchHelper(data, root.right);
        }else{
			// call left
            return searchHelper(data, root.left);
        }
    }
	
	public void printTree() {
		//Implement the printTree() function
        printTree(root);
	}
        
    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String toBePrinted = root.data + ":";
        if(root.left != null){
            toBePrinted += "L:" + root.left.data + ",";
        }
        if(root.right != null){
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }
}