package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * AppendLastNToFirst
 */
class Append<T> {
    T data;
    Append<T> next;
    
    public Append(T data) {
        this.data = data;
    }
}
public class AppendLastNToFirst {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Append<Integer> takeInput() throws IOException {
        Append<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Append<Integer> newNode = new Append<Integer>(data);
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
    
    public static void print(Append<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            Append<Integer> head = takeInput(); 

            int n = Integer.parseInt(br.readLine().trim());
            head = AppendLastNToFirst.appendLastNToFirst(head, n);
            print(head);

            t -= 1;
        }
        
    }

    public static Append<Integer> appendLastNToFirst(Append<Integer> head, int n) {
        Append<Integer> temp = head,tail = null,newHead = null;
        int length = 0;
        if(head == null){
            return head;
        }
		while(tail != null && head.next != null){
            tail = head.next;
            length++;
        }
        for(int i = 0; i <= length - n; i++){
            newHead = head.next;
        }
        System.out.println(head.data);
        tail.next = head;
        head.next = temp;
        return newHead;
    }

    
}