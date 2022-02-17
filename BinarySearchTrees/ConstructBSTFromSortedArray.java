package BinarySearchTrees;

import java.io.*;
import java.util.*;

public class ConstructBSTFromSortedArray {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void preOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int arr[] = new int[len];
		if(len>0)
		{
			st = new StringTokenizer(br.readLine());
		}
		for(int i=0;i<len;i++)
		{
		    arr[i]=Integer.parseInt(st.nextToken());
		}
		BinaryTreeNode<Integer> ans = ConstructBSTFromSortedArray.SortedArrayToBST(arr, len);
		preOrder(ans);
	}

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        return helper(arr,0,n-1);
    }

    public static BinaryTreeNode<Integer> helper(int[] arr, int si, int ei){
        if(si>ei){
            return null;
        }
        int mid = (ei+si)/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
        root.left = helper(arr,si,mid-1);
        root.right = helper(arr,mid+1,ei);
        return root;
    }

}