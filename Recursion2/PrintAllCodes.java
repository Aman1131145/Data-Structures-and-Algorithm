package Recursion2;

public class PrintAllCodes{

    /** */

    public class solution {

        // Return a 2D array that contains all the subsets
        public static int[][] subsets(int input[]) {
            // Write your code here
            return subsets(input,0);
        }
        
        public static int[][] subsets(int input[],int index) {
            // Write your code here
            if(index==input.length-1){
                int ans[][]=new int[1][1];
                ans[0][0]=input[index];
                return ans;
            }
            int smallAns[][]=subsets(input,index+1);
            int ans[][]=new int[smallAns.length*2+1][];
            int i;
            for(i=0;i<smallAns.length;i++){
                ans[i]=new int[smallAns[i].length];
                for(int j=0;j<ans[i].length;j++){
                    ans[i][j]=smallAns[i][j];
                }
            }
            ans[i]=new int[1];
            ans[i++][0]=input[index];
            
            for(int k=0;i<ans.length;i++,k++){
                ans[i]=new int[smallAns[k].length+1];
                ans[i][0]=input[index];
                for(int j=1;j<ans[i].length;j++){
                    ans[i][j]=smallAns[k][j-1];
                }
            }
            return ans;
            
        }
    }
    
}