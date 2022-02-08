package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TreeUse {
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        
        // TreeNode<Integer> root = takeInput(s);
        TreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        // TreeNode<Integer> root = new TreeNode<>(1);
        // TreeNode<Integer> node1 = new TreeNode<>(2);
        // TreeNode<Integer> node2 = new TreeNode<>(3);
        // TreeNode<Integer> node3 = new TreeNode<>(4);
        // TreeNode<Integer> node4 = new TreeNode<>(5);

        // root.children.add(node1);
        // root.children.add(node2);
        // root.children.add(node3);
        // root.children.add(node4);

        // System.out.println(root);
    }

    private static void printLevelWise(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        //added 1st level here 
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty())
        {
            TreeNode<Integer> frontNode = queue.remove();
            if(frontNode == null){
                if(queue.isEmpty()){
                    break;
                }
                System.out.println();
                queue.add(null);
            }else{
                System.out.print(frontNode.data+" ");
                for(int i=0;i<frontNode.children.size();i++){
                    queue.add(frontNode.children.get(i));
                }
            }
            
        }
    }

    // private static void print(TreeNode<Integer> root){
    //     String s = root.data + " : ";
    //     for(int i = 0; i < root.children.get(i).data;i++){
    //         s = s + root.children.get(i).data + ",";
    //     }
    //     System.out.println(s);
    //     for (int i = 0; i < root.children.size(); i++) {
    //         print(root.children.get(i));            
    //     }
    // }

    // private static TreeNode<Integer> takeInput(Scanner s) {
    //     int n; 
    //     System.out.println("Enter next Node data : ");
    //     n = s.nextInt();
    //     TreeNode<Integer> root = new TreeNode<>(n);
    //     System.out.println("Enter number of children for " + n + " : ");
    //     int childCount = s.nextInt();
    //     for(int i = 0; i < childCount; i++){
    //         TreeNode<Integer> child = takeInput(s);
    //         root.children.add(child);
    //     }
    //     return root;
    // }
    
    private static TreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data : ");
        int rootData = s.nextInt();
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            try {
                TreeNode<Integer> frontNode = pendingNodes.poll();
                System.out.println("Enter num of children of " + frontNode.data + " : ");
                int numChildren = s.nextInt();
                for (int i = 0; i < numChildren; i++) {
                    System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data + " : ");
                    int child = s.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<Integer>(child);
                    frontNode.children.add(childNode);
                    pendingNodes.add(childNode);
                    
                }
            } catch (Exception e) {
                return null;
            }
        }
        return root;
    }
}
