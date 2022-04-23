package Graphs;

import java.util.*;
import java.io.*;

public class HasPath {
    
    public static boolean hasPath(int edges[][], int sv, int ev, boolean visited[]){
        boolean ans = false;
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while(!q.isEmpty()){
            int fv = q.remove();
            if(fv == ev){
                ans = true;
                break;
            }
            for(int i = 0; i < edges.length; i++){
                if(edges[fv][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
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
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        
        boolean visited[] = new boolean[edges.length];
        System.out.println(hasPath(edges,v1,v2,visited));
        sc.close();
	}

}
