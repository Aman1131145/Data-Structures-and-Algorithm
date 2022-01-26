package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Find<T> {
    T data;
    Find<T> next;
    
    public Find(T data) {
        this.data = data;
    }
}

public class FindNode {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Find<Integer> takeInput() throws IOException {
        Find<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Find<Integer> newNode = new Find<Integer>(data);
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
    
    public static void print(Find<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            Find<Integer> head = takeInput(); 
            int n = Integer.parseInt(br.readLine().trim());
            
            System.out.println(FindNode.findNode(head, n));

            t -= 1;
        }
        
    }

    public static int findNode(Find<Integer> head, int n) {
        if(head == null){
            return -1;
        }
        int i = 0;
        while(head.data != n && head.next != null){
            head = head.next;
            i++;
        }
        if(head.data != n){
            return -1;
        }
        return i;
    }
    
}
