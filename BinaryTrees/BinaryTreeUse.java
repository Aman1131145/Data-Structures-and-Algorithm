package BinaryTrees;

import java.util.*;

public class BinaryTreeUse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // BinaryTreeNode<Integer> root = takeInput(s);
        System.out.print("Enter the Number you want to find in the tree : ");
        System.out.println();
        int x = s.nextInt();
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println("Number of Nodes in this tree : " + countNodes(root));
        
        System.out.println(isNodePresent(root, x));
        System.out.println("Height of the tree is : " + heightDiameter(root).first);
        System.out.println("Diameter of the tree : " + heightDiameter(root).second);
        System.out.print("Preorder : ");
        preorder(root);
        System.out.println();
        System.out.println("PostOrder : ");
        postorder(root);
        System.out.println();
        System.out.println("Inorder : ");
        inorder(root);
        System.out.println();
        System.out.println("And here is the mirror tree");
        mirrorBinaryTree(root);
        printLevelWise(root);
        // s.close();
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        // BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
        // root.left = node1;
        // BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(3);
        // root.right = node2;
        s.close();
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
   
    public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<Integer,Integer> output = new Pair<>();
            output.first = 0;
            output.second = 0;
            return output;
        }
        Pair<Integer,Integer> lo = heightDiameter(root.left),ro = heightDiameter(root.right);
        int height = 1 + Math.max(lo.first, ro.first);
        int option1 = lo.first + ro.first;
        int option2 = lo.second;
        int option3 = ro.second;
        int diameter = Math.max(option1, Math.max(option2, option3));
        Pair<Integer,Integer> output = new Pair<>();
        output.first = height;
        output.second = diameter;
        return output;
        
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
    
    public static void inorder(BinaryTreeNode<Integer> root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void preorder(BinaryTreeNode<Integer> root){
        if(root == null){
            return ;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(BinaryTreeNode<Integer> root){
        if(root == null){
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    /*// public static int height(BinaryTreeNode<Integer> root) {
    //     //Your code goes here
    //     if(root == null){
    //         return 0;
    //     }
    //     int leftHeight = height(root.left);
    //     int rightHeight = height(root.right);
    //     return 1 + Math.max(leftHeight, rightHeight);
    // }
    
    // public static int diameter(BinaryTreeNode<Integer> root){
    //     if (root == null){
    //         return 0;
    //     }
    //     int option1 = height(root.left) + height(root.right);
    //     int option2 = diameter(root.left);
    //     int option3 = diameter(root.right);
    //     return Math.max(option1 , Math.max(option2, option3));
    // }
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
    */
}