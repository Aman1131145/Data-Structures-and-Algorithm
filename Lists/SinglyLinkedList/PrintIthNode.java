package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PrintIthNode
 */
class Print<T> {
    T data;
    Print<T> next;
    
    public Print(T data) {
        this.data = data;
    }
}
public class PrintIthNode {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Print<Integer> takeInput() throws IOException {
        Print<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Print<Integer> newNode = new Print<Integer>(data);
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
    
    public static void print(Print<Integer> head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {   
            Print<Integer> head = takeInput(); 
            int i = Integer.parseInt(br.readLine().trim());   
            PrintIthNode.printIthNode(head, i);

            t -= 1;
        }
    }

    public static void printIthNode(Print<Integer> head, int i) {
        for(int j=0; j<i && head != null; j++) {
            head = head.next;
        }
        if(head != null) {   
            System.out.print(head.data);
        }
    }
}