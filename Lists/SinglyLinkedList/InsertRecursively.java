package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Insert<T> {
    T data;
    Insert<T> next;
    
    public Insert(T data) {
        this.data = data;
    }
}

public class InsertRecursively {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Insert<Integer> takeInput() throws IOException {
        Insert<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Insert<Integer> newNode = new Insert<Integer>(data);
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
    
    public static void print(Insert<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t > 0) {
            Insert<Integer> head = takeInput(); 
            
            int pos = Integer.parseInt(br.readLine().trim());
            int elem = Integer.parseInt(br.readLine().trim());
            head = InsertRecursively.insert(head, pos, elem);
            print(head);
            
            t -= 1;
        }
    }
    public static Insert<Integer> insert(Insert<Integer> head, int pos, int elem){
        if(pos == 0){
            Insert<Integer> newNode = new Insert<>(elem);
            newNode.next = head;
            return newNode;
        }
        if(head == null){
            return head;
        }
    
        head.next = insert(head.next, pos - 1, elem);
        return head;
        
    }
}
