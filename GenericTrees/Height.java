package GenericTrees;

import java.util.*;

/**
 * GreaterNodes
 */
public class Height {

    public static void main(String[] args) {       
        TreeNode<Integer> root = takeInputLevelWise();
        System.out.println(heightOfTree(root));
    }

    private static int heightOfTree(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        int height = 1;
		int currChildHeight = 0;
		int childHeight = 0;
        
        for(int i = 0; i < root.children.size(); i++){
			currChildHeight = heightOfTree(root.children.get(i));
			if(childHeight < currChildHeight){
				childHeight = currChildHeight;
			}
        }
        height += childHeight;
        return height;
        
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