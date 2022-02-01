package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class reverseK<T> {
    T data;
    reverseK<T> next;
    
    public reverseK(T data) {
        this.data = data;
    }
}

public class KReverse {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static reverseK<Integer> takeInput() throws IOException {
        reverseK<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            reverseK<Integer> newNode = new reverseK<Integer>(data);
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
    
    public static void print(reverseK<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            reverseK<Integer> head = takeInput();
            int k = Integer.parseInt(br.readLine().trim());

            reverseK<Integer> newHead = KReverse.kReverse(head, k);
            print(newHead);
            
            t -= 1;
        }

    }
    public static reverseK<Integer> kReverse(reverseK<Integer> head, int k) {
        if(head==null || head.next == null || k <= 0)
            return head;
        reverseK<Integer> h1=head,h2,t1=head;
        int count=1;        
	    while(count<k && t1.next!=null)
     	{
        	t1=t1.next;
        	count++;
     	}
          
		h2=t1.next;
        t1.next=null;

        DoubleNode ans=reversePart(h1);
        reverseK<Integer> secondHead=kReverse(h2,k);
        ans.tail.next=secondHead;
        return ans.head;
    }
    private static DoubleNode reversePart(reverseK<Integer> head)
    {
        if(head==null || head.next==null){
            DoubleNode ans=new DoubleNode();
        	ans.head=head;
        	ans.tail=head;
        	return ans;
        }
     
        DoubleNode ans=reversePart(head.next);
        ans.tail.next=head;
        head.next=null;
        ans.tail=ans.tail.next;
        return ans;
    }
}
class DoubleNode{
    reverseK<Integer> head;
    reverseK<Integer> tail;
}