package Graphs;

import java.util.*;
import java.io.*;

public class GetPathDFS {

    public static ArrayList<Integer> getPath(int edges[][], int sv, int ev, boolean visited[]){
        if(sv == ev){
            ArrayList<Integer> ans = new ArrayList<>();
            visited[ev] = true;
            ans.add(ev);
            return ans;
        }
        visited[sv] = true;
        for(int i = 0; i < edges.length; i++){
            if(edges[sv][i] == 1 && !visited[i]){
                ArrayList<Integer> arr = getPath(edges,i,ev,visited);
                if(arr != null){
                    arr.add(sv);
                    return arr;
                }
            }
        }
        return null;
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
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        
        boolean visited[] = new boolean[v];
        ArrayList<Integer> ans = getPath(edges,v1,v2,visited);
        if(ans!= null){
            for(int i : ans){
                System.out.print(i + " ");
            }
        }
        sc.close();
	}
    
}
