package Graphs;

import java.util.*;
import java.io.*;

public class IsConnected {

    public static boolean printHelper(int edges[][], int sv, boolean visited[]){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(sv);
        visited[sv] = true;
        while(!q.isEmpty()){
        	int fv = q.remove();
            for(int i = 0; i < edges.length; i++){
                if(edges[fv][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        for(boolean check : visited){
            if(check == false){
                return false;
            }
        }
        return true;
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
        boolean visited[] = new boolean[edges.length];
        if(v == 0){
            System.out.println(true);
        }else{
            System.out.println(printHelper(edges,0,visited));
        }
        sc.close();
	}
    
}
