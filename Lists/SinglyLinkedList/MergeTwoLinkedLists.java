package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * MergeTwoLinkedLists
 */
class Merge<T> {
    T data;
    Merge<T> next;
    
    public Merge(T data) {
        this.data = data;
    }
}

public class MergeTwoLinkedLists {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Merge<Integer> takeInput() throws IOException {
        Merge<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Merge<Integer> newNode = new Merge<Integer>(data);
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
    
    public static void print(Merge<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            Merge<Integer> head1 = takeInput(); 
            Merge<Integer> head2 = takeInput(); 

            Merge<Integer> newHead = MergeTwoLinkedLists.mergeTwoSortedLinkedLists(head1, head2);
            print(newHead);
            
            t -= 1;
        }

    }

    public static Merge<Integer> mergeTwoSortedLinkedLists(Merge<Integer> head1,Merge<Integer> head2) {
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
		Merge<Integer> head = null , tail= null;
        if(head1.data<=head2.data){
            head = head1;
            tail = head1;
            head1 = head1.next;
        }
        else{
            head = head2;
            tail = head2;
            head2 = head2.next;
        }
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                tail.next = head1;
                tail = head1;
                head1 = head1.next;    
            }
            else{
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }   
        }
        if(head1!=null){
            tail.next = head1;
        }
        if(head2!=null){
            tail.next = head2;
        }
        return head;
    }
}