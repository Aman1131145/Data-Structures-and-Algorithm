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

    public static void main(String[] args) {
        System.out.println(lcsR("dgei", "begi"));
    }
}
