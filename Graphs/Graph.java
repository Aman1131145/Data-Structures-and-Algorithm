package Graphs;

import java.util.*;

public class Graph {

    public static void printDFSHelper(int edges[][], int sv, boolean visited[]){
        System.out.println(sv);
        visited[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if(edges[sv][i] == 1 && !visited[i]){
                printDFSHelper(edges, i, visited);
            }
        }
    }

    public static void printBFSHelper(int edges[][], int sv, boolean visited[]){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(sv);
        visited[sv] = true;
        while(!q.isEmpty()){
        	int fv = q.remove();
            System.out.print(fv + " ");
            for(int i = 0; i < edges.length; i++){
                if(edges[fv][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void BFS(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            if(!visited[i]){
                printBFSHelper(edges, i, visited);
            }
        }
    }

    public static void DFS(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            if(!visited[i]){
                printDFSHelper(edges,i,visited);
            }
        }
    }
    public static void main(String[] args) {
        int n,e;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        int edges[][] = new int[n][n];
        for(int i = 0; i < e; i++){
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        System.out.println("DFS");
        DFS(edges);
        System.out.println("BFS");
        BFS(edges);
        sc.close();
    }
}