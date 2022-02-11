package BinaryTrees;

import java.util.*;

public class BinaryTreeUse {
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // BinaryTreeNode<Integer> root = takeInput(s);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println("Number of Nodes in this tree : " + countNodes(root));
        // s.close();
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        // BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
        // root.left = node1;
        // BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(3);
        // root.right = node2;
    }
    
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        try (Scanner s = new Scanner(System.in)) {
            Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
            System.out.println("Enter root data");
            int rootData = s.nextInt();
            if(rootData == -1){
                return null;
            }
            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
            queue.add(root);
            
            while(!queue.isEmpty()){
                BinaryTreeNode<Integer> front;
                try{
                    front = queue.remove();
                } catch (Exception e) {
                    return null;
                }
                System.out.println("Enter left child of " + front.data);
                int leftChild = s.nextInt();
                if(leftChild != -1){
                    BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
                    queue.add(child);
                    front.left = child;
                }
                System.out.println("Enter right child of " + front.data);
                int rightChild = s.nextInt();
                if(rightChild != -1){
                    BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
                    queue.add(child);
                    front.right = child;
                }
            }
            return root;
        }
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.remove();
            if(frontNode == null){
                if(queue.isEmpty()){
                    break;
                }
                System.out.println();
            }
            else{
                System.out.print(frontNode.data + ":");
                if(frontNode.left != null){
                    queue.add(frontNode.left);
                    System.out.print("L:" + frontNode.left.data + ",");
                }else{
                    System.out.print("L:-1,");
                }
                if(frontNode.right != null){
                    queue.add(frontNode.right);
                    System.out.print("R:" + frontNode.right.data);
                }else{
                    System.out.print("R:-1");
                }
            }
            System.out.println();
        }
	}
    
    public static int countNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int ans = 1;
        ans += countNodes(root.left);
        ans += countNodes(root.right);
        return ans;
    }

    static boolean isPresent;
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    //Your code goes here
        if(root == null){
            return false;
        }
        if(root.data == x){
            return isPresent = true;
        }
        isNodePresent(root.left,x);
        isNodePresent(root.right,x);
        return isPresent;
	}

    static int count = 1;
	public static int height(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight > rightHeight){
            count = leftHeight + 1;
        }else{
            count = rightHeight + 1;
        }
        return count;
	}

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
        if(root == null){
            return;
        }
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
	}
    // private static BinaryTreeNode<Integer> takeInput(Scanner s) {
    //     int rootData;
    //     System.out.println("Enter root data");
    //     rootData = s.nextInt();
    //     if(rootData == -1){
    //         return null;
    //     }
    //     BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
    //     root.left = takeInput(s);
    //     root.right = takeInput(s);
    //     return root;
    // }

    // public static void printTree(BinaryTreeNode<Integer> root){
    //     if(root == null){
    //         return;
    //     }
    //     String toBePrinted = root.data + ":";
    //     if(root.left != null){
    //         toBePrinted += "L:" + root.left.data + ",";
    //     }
    //     if(root.right != null){
    //         toBePrinted += "R:" + root.right.data;
    //     }
    //     System.out.println(toBePrinted);
    //     printTree(root.left);
    //     printTree(root.right);
    // }
}