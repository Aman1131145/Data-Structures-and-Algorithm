package DP2;

public class LCS {  
    
    public static int lcsR(String s, String t){
        if(s.length() == 0 || t.length() == 0){
            return 0;
        }
        if(s.charAt(0) == t.charAt(0)){
            return 1+lcsR(s.substring(1), t.substring(1));
        }else{
            int op1 = lcsR(s, t.substring(1));
            int op2 = lcsR(s.substring(1), t);


            // int op3 = lcsR(s.substring(1), t.substring(1));
            /** we don't have to consider the op3 explicitly because 
             * it will be taken care int the op1 and op2
             */
            
            return Math.max(op1, op2);//Math.max(op2, op3));
        }
    }

    public static int lcsM(String s, String t){
         int storage[][] = new int[s.length()+1][t.length()+1];
         for (int i = 0; i < s.length()+1; i++) {
             for (int j = 0; j < t.length()+1; j++) {
                 storage[i][j] = -1;                 
             }
             
         }
         return lcsM(s, t, storage);
    }

    public static int lcsM(String s, String t, int storage[][]){
        int m = s.length();
        int n = t.length();

        if(storage[m][n] != -1){
            return storage[m][n];
        }
        if(m==0||n==0){
            storage[m][n] = 0;
            return storage[m][n];
        }
        if(s.charAt(0) == t.charAt(0)){
            storage[m][n] = 1 + lcsM(s.substring(1), t.substring(1), storage);
        }else{
            int op1 = lcsM(s, t.substring(1), storage);
            int op2 = lcsM(s.substring(1), t, storage);
            storage[m][n] = Math.max(op1, op2);
        }
        return storage[m][n];
    }

    public static void main(String[] args) {
        System.out.println(lcsM("helloauntyji", "whatthehellisthis"));
        System.out.println(lcsR("helloauntyji", "whatthehellisthis"));
    }
}
