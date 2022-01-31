package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DeleteN<T> {
    T data;
    DeleteN<T> next;
    
    public DeleteN(T data) {
        this.data = data;
    }
}

public class DeleteEveryNNodes {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static DeleteN<Integer> takeInput() throws IOException {
        DeleteN<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            DeleteN<Integer> newNode = new DeleteN<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
    
    public static void print(DeleteN<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            DeleteN<Integer> head = takeInput();
            String[] m_n = br.readLine().trim().split("\\s");

            int m = Integer.parseInt(m_n[0]);
            int n = Integer.parseInt(m_n[1]);

            DeleteN<Integer> newHead = DeleteEveryNNodes.skipMdeleteN(head, m, n);
            print(newHead);
            
            t -= 1;
        }

    }

    public static DeleteN<Integer> skipMdeleteN(DeleteN<Integer> head, int M, int N) {
		//Your code goes here
        if(head == null || N == 0){
            return head;
        }
        if(M == 0){
            return null;
        }
        DeleteN<Integer> temp = head;

        while(head != null){
        	int count1 = 1;
            int count2 = 0;
            
            while(count1 != M){
                if(head == null || head.next == null){
                    break;
                }
                head = head.next;
                count1++;
            }
            while(count2 != N){
                if(head == null || head.next == null){
                    break;
                }
                head.next = head.next.next;
                count2++;
            }
            head = head.next;
        }
        head = temp;
        return head;
	}
}
