package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DeleteR<T> {
    T data;
    DeleteR<T> next;
    
    public DeleteR(T data) {
        this.data = data;
    }
}

public class DeleteNodeRecursive {  

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static DeleteR<Integer> takeInput() throws IOException {
        DeleteR<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            DeleteR<Integer> newNode = new DeleteR<Integer>(data);
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
    
    public static void print(DeleteR<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            DeleteR<Integer> head = takeInput();
            int pos = Integer.parseInt(br.readLine().trim());

            DeleteR<Integer> newHead = DeleteNodeRecursive.deleteNodeRec(head, pos);
            print(newHead);
            
            t -= 1;
        }

    }

    public static DeleteR<Integer> deleteNodeRec(DeleteR<Integer> head, int pos) {
        DeleteR<Integer> temp;
        if(pos == 0){
            head = head.next;
            return head;
        }
        if(head.next == null){
            return head;
        }
        temp = deleteNodeRec(head.next,pos-1);
        head.next = temp;
        return head;
    }
    
}
