package Test1;

import java.util.Scanner;

public class DoesSContainT {

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String large = s.nextLine();
		String small = s.nextLine();

		System.out.println(DoesSContainT.checkSequence(large, small));
        s.close();
	}

    public static boolean checkSequence(String a, String b) {
        if(a.length() == 0 || b.length() == 0){
            return true;
        }

        boolean smallAns = false;
        
        if(a.substring(0, 1) == b.substring(0,1)){
            smallAns = true;
            checkSequence(a.substring(1), b);
        }
        return smallAns;
    }
    
}
