package Graphs;

import java.io.*;

public class Islands {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] takeInput() throws IOException {
		String[] strNums;
        strNums = br.readLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);

        int[][] edges = new int[n][n];
        int firstvertex, secondvertex;

        for (int i = 0; i < e; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s");
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            edges[firstvertex][secondvertex] = 1;
            edges[secondvertex][firstvertex] = 1;
        }
        return edges;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        int [][]edges = takeInput();
        
        int ans = Islands.numConnected(edges, edges.length);
        System.out.println(ans);
		
	}

    public static int numConnected(int[][] edges, int n) {
		boolean visited[] = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                helper(edges,i,visited);
            }
        }
        return count;
	}
    
    public static void helper(int edges[][], int sv, boolean visited[]){
        visited[sv] = true;
        int n = edges.length;
        for(int i = 0; i < n; i++){
			if(edges[sv][i] == 1 && !visited[i]){
                helper(edges,i,visited);
            }
        }
    }
    
}
