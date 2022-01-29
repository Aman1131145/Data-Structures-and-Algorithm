package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ReverseR<T> {
    T data;
    ReverseR<T> next;
    
    public ReverseR(T data) {
        this.data = data;
    }
}

public class ReverseLinkedListRecursive {  

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static ReverseR<Integer> takeInput() throws IOException {
        ReverseR<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            ReverseR<Integer> newNode = new ReverseR<Integer>(data);
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
    
    public static void print(ReverseR<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            ReverseR<Integer> head = takeInput();
            ReverseR<Integer> newHead = ReverseLinkedListRecursive.reverseR(head);
            print(newHead);
            
            t -= 1;
        }

    }
    public static ReverseR<Integer> reverseR(ReverseR<Integer> head) {
        if(head==null || head.next==null){
            return head;
        }

        ReverseR<Integer> finalhead = reverseR(head.next);
        ReverseR<Integer> temp = finalhead; 
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return finalhead;
    }

    public static ReverseR<Integer> reverseLinkedListRec(ReverseR<Integer> head) {
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        ReverseR<Integer> tail=head.next;
        ReverseR<Integer> smallhead=reverseLinkedListRec(head.next);
        tail.next=head;
        head.next=null;
        return smallhead;
	}
    

}