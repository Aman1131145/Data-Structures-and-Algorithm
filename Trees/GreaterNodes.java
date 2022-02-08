package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * GreaterNodes
 */
public class GreaterNodes {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int x = s.nextInt();
        TreeNode<Integer> root = takeInputLevelWise();
        System.out.println(numNodeGreater(root,x));
        s.close();
    }

    private static int numNodeGreater(TreeNode<Integer> root, int x) {
        if(root == null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < root.children.size(); i++) {
            count += numNodeGreater(root.children.get(i), x);
        }
        if(root.data > x){
            count++;
        }
        return count;
    }

    private static TreeNode<Integer> takeInputLevelWise(){
        try (Scanner s = new Scanner(System.in)) {
            
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
}