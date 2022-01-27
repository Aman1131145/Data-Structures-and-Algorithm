package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MergeSort<T> {
    T data;
    MergeSort<T> next;
    
    public MergeSort(T data) {
        this.data = data;
    }
}

public class MergeSortList {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static MergeSort<Integer> takeInput() throws IOException {
        MergeSort<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            MergeSort<Integer> newNode = new MergeSort<Integer>(data);
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
    
    public static void print(MergeSort<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            MergeSort<Integer> head = takeInput();

            MergeSort<Integer> newHead = MergeSortList.mergeSort(head);
            print(newHead);
            
            t -= 1;
        }

    }

    public static MergeSort<Integer> mergeSort(MergeSort<Integer> head) {
		//Your code goes here
        if(head == null || head.next == null){
            return head;
        }
        
        MergeSort<Integer> mid = midPoint(head), head1, head2, merge;
        head1 = head;
        head2 = mid.next;
        merge = merge(head1,head2);
        head = merge;
        return head;
	}
    
    private static MergeSort<Integer> midPoint(MergeSort<Integer> head) {
        //Your code goes here
        MergeSort<Integer> slow = head,fast = head;
        if(head == null || head.next == null){
            return head;
        }
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private static MergeSort<Integer> merge(MergeSort<Integer> head1, MergeSort<Integer> head2){        
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
		MergeSort<Integer> head = null , tail= null;
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
