package Graphs;

import java.io.*;
import java.util.*;

public class GetPathBFS {

    public static ArrayList<Integer> getPath(int edges[][], int sv, int ev, boolean visited[]){
        if(sv==ev)
        {
            ArrayList<Integer> ans=new ArrayList<Integer>();
            ans.add(ev);
            visited[ev]=true;
            return ans;
        }
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(sv);
        visited[sv] = true;
        while(!q.isEmpty()){
            int front = q.remove();
            for(int i = 0; i < edges.length; i++){
                if(edges[front][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                    map.put(i,front);
                    if(i==ev){
                        ans.add(i);
                        while(!ans.contains(sv)){
                            int b = map.get(i);
                            ans.add(b);
                            i=b;
                        }
                        return ans;
                    }
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
