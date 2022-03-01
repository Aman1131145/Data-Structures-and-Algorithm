package Test3;

import java.util.*;

class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> children;

	TreeNode(T data){
		this.data = data;
		children = new ArrayList<TreeNode<T>>();
	}
}

public class RemoveLeafNode {
    
    static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.remove();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.add(childNode);
					currentNode.children.add(childNode);
				}
			} catch (Exception e) {
			}
		}
		return root;
	}

	public static void printTreeLevelWise(TreeNode<Integer> root){
		if(root == null) {
			return;
		}
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<TreeNode<Integer>>(); 
		pendingNodes.add(root);
		pendingNodes.add(null);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode = null;
			try {
				currentNode = pendingNodes.remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(currentNode == null) {
				if(pendingNodes.isEmpty()) {
					break;
				}
				System.out.println();
				pendingNodes.add(null);
				continue;
			}
			System.out.print(currentNode.data + " ");
			int numChild = currentNode.children.size();
			for(int i = 0 ; i < numChild; i++){
				pendingNodes.add(currentNode.children.get(i));
			}
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		root = RemoveLeafNode.removeLeafNodes(root);
		printTreeLevelWise(root);
	}

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if (root.children.size() == 0){
              root = null;
              return root;
        }
        for(int i=root.children.size()-1 ; i >= 0 ; i--){
               if (removeLeafNodes(root.children.get(i)) == null){
                    root.children.remove(root.children.get(i));
             }
        }
        return root;
	}
}
