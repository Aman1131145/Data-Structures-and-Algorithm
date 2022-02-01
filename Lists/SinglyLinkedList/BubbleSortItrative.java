package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bubble<T> {
    T data;
    Bubble<T> next;
    
    public Bubble(T data) {
        this.data = data;
    }
}

public class BubbleSortItrative {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Bubble<Integer> takeInput() throws IOException {
        Bubble<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Bubble<Integer> newNode = new Bubble<Integer>(data);
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
    
    public static void print(Bubble<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	Bubble<Integer> head = takeInput(); 

    	head = BubbleSortItrative.bubbleSort(head);
    	print(head);
    }

    public static Bubble<Integer> bubbleSort(Bubble<Integer> head )
	{    
        if(head==null || head.next==null)
        	return head;
        //Write your code here
        for(int i=0;i<lengthLL(head)-1;i++){
            Bubble<Integer> prev = null;
            Bubble<Integer> curr = head;
            Bubble<Integer> next = curr.next;

            while(curr.next != null){
                if(curr.data > curr.next.data){
                    if(prev == null){
                        curr.next = next.next;
                        next.next = curr;
                        prev = next;
                        head = prev;
                    }else{
                        next = curr.next;
                        curr.next = next.next;
                        prev.next = next;
                        next.next = curr;
                        prev = next;
                    }
                }else{
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return head;
    }
    
    private static int lengthLL(Bubble<Integer> head){
        int count = 1;
        while(head.next != null){
            head = head.next;
            count++;
        }
        return count;
    }
}