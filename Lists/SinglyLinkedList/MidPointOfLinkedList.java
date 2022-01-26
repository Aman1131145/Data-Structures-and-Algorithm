package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Mid<T> {
    T data;
    Mid<T> next;
    
    public Mid(T data) {
        this.data = data;
    }
}

public class MidPointOfLinkedList {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Mid<Integer> takeInput() throws IOException {
        Mid<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Mid<Integer> newNode = new Mid<Integer>(data);
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
    
    public static void print(Mid<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            Mid<Integer> head = takeInput(); 

            Mid<Integer> mid = MidPointOfLinkedList.midPoint(head);
            
            if (mid != null) {
                System.out.println(mid.data);
            }

            t -= 1;
        }

    }

    public static Mid<Integer> midPoint(Mid<Integer> head) {
        
        Mid<Integer> slow = head,fast = head;
        if(head == null || head.next == null){
            return head;
        }
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
}
