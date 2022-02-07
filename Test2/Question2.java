package Test2;

import java.util.Scanner;

public class Question2 {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        Dequeue dq = new Dequeue(10);
        
        while(true){
            int choice = s.nextInt(),input;
            switch (choice) {
                case 1:
                    input = s.nextInt();
                    dq.insertFront(input);
                    break;
                case 2:
                    input = s.nextInt();
                    dq.insertRear(input);
                    break;
                case 3:
                    dq.deleteFront();
                    break;
                case 4:
                    dq.deleteRear();
                    break;
                case 5:
                    System.out.println(dq.getFront());
                    break;
                case 6:
                    System.out.println(dq.getRear());
                    break;
                default:
                    return ;
            }
            s.close();
        }
    }
}