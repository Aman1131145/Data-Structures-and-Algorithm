package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Delete<T> {
    T data;
    Delete<T> next;
    
    public Delete(T data) {
        this.data = data;
    }
}

public class DeleteNode {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Delete<Integer> takeInput() throws IOException {
        Delete<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Delete<Integer> newNode = new Delete<Integer>(data);
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
    
    public static void print(Delete<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            Delete<Integer> head = takeInput(); 

            int pos = Integer.parseInt(br.readLine().trim());
            head = DeleteNode.deleteNode(head, pos);
            print(head);

            t -= 1;
        }
    }

    public static Delete<Integer> deleteNode(Delete<Integer> head, int pos) {
        Delete<Integer> temp = head;
        if(head == null){
            return head;
        }
        if(pos == 0){
          
            return head.next;
        }
        int i = 0;
        while(temp != null &&i < pos-1){
            temp = temp.next;
            i++;
        }
        if(temp == null || temp.next==null){
            return head;
        }
        temp.next=temp.next.next;
        return head;
    }
    
}
