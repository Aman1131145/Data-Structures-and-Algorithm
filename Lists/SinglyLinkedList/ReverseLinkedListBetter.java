package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ReverseB<T> {
    T data;
    ReverseB<T> next;
    
    public ReverseB(T data) {
        this.data = data;
    }
}

public class ReverseLinkedListBetter {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static ReverseB<Integer> takeInput() throws IOException {
        ReverseB<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            ReverseB<Integer> newNode = new ReverseB<Integer>(data);
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
    
    public static void print(ReverseB<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        ReverseB<Integer> head = takeInput();
        DoubleNode ans = reverseB(head);
        print(ans.head);
    }

    public static DoubleNode reverseB(ReverseB<Integer> head) {
        if(head == null || head.next == null){
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }

        DoubleNode smallAns = reverseB(head.next);
        smallAns.tail.next = head;
        head.next = null;

        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }
    
}
