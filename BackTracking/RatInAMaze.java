package BackTracking;

import java.util.*;

public class RatInAMaze {

    public static boolean isSafe(int maze[][], int x, int y)
    {
        int N = maze.length;
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0
                && y < N && maze[x][y] == 1);
    }
 
    public static boolean ratInAMaze(int maze[][])
    {
        int N = maze.length;
        int sol[][] = new int[N][N];
 
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            return false;
        } 
        return true;
    }
 
    /* A recursive utility function to solve Maze
    problem */
    public static boolean solveMazeUtil(int maze[][], int x, int y,
                          int sol[][])
    {
        int N = maze.length;
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1
            && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
 
        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y) == true) {
              // Check if the current block is already part of solution path.   
              if (sol[x][y] == 1)
                  return false;
           
            // mark x, y as part of solution path
            sol[x][y] = 1;
 
            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;
 
            /* If moving in x direction doesn't give
            solution then Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;
           
            /* If moving in y direction doesn't give
            solution then Move backwards in x direction */
            if (solveMazeUtil(maze, x - 1, y, sol))
                return true;
 
            /* If moving backwards in x direction doesn't give
            solution then Move upwards in y direction */
            if (solveMazeUtil(maze, x, y - 1, sol))
                return true;
 
            /* If none of the above movements works then
            BACKTRACK: unmark x, y as part of solution
            path */
            sol[x][y] = 0;
            return false;
        }
 
        return false;
    }

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int maze[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				maze[i][j] = s.nextInt();
			}
		}
		System.out.println(RatInAMaze.ratInAMaze(maze));	
        s.close();
	}
    
}
