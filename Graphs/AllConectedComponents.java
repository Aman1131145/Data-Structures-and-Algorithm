package Graphs;

import java.util.*;
import java.io.*;

public class AllConectedComponents {

    public static ArrayList<Integer> printHelper(int edges[][], int sv, boolean visited[], ArrayList<Integer> arr){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(sv);
        visited[sv] = true;
        while(!q.isEmpty()){
        	int fv = q.remove();
            arr.add(fv);
            for(int i = 0; i < edges.length; i++){
                if(edges[fv][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return arr;
    }
    
    public static ArrayList<ArrayList<Integer>> print(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            if(!visited[i]){
                arr = printHelper(edges,i,visited,arr);
                ans.add(arr);
            }
        }
        return ans;
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        int edges[][] = new int[v][v];
        for(int i = 0; i < e; i++){
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = print(edges);
        for(int i = 0; i < ans.size(); i++){
            for(int j = 0; j < ans.get(i).size(); j++){
                Collections.sort(ans.get(i));
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        sc.close();
	}
    
}
