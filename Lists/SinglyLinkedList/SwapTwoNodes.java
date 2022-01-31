package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Swap<T> {
    T data;
    Swap<T> next;
    
    public Swap(T data) {
        this.data = data;
    }
}

public class SwapTwoNodes {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Swap<Integer> takeInput() throws IOException {
        Swap<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Swap<Integer> newNode = new Swap<Integer>(data);
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
    
    public static void print(Swap<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            Swap<Integer> head = takeInput();
            String[] i_j = br.readLine().trim().split("\\s");

            int i = Integer.parseInt(i_j[0]);
            int j = Integer.parseInt(i_j[1]);

            Swap<Integer> newHead = SwapTwoNodes.swapNodes(head, i, j);
            print(newHead);
            
            t -= 1;
        }

    }

    public static Swap<Integer> swapNodes(Swap<Integer> head, int i, int j) {
        if(head == null || head.next == null || i == j){
            return head;
        }
        Swap<Integer>temp = head, firstp = null, first = null, firstn = null, lastp = null, last = null, lastn = null;
        int k = 0;
        int smallerThanI = i - 1;
        int biggerThanI = i + 1;
        int smallerThanJ = j - 1;
        int biggerThanJ = j + 1;
        
        while(head != null ){
            if(k == smallerThanI){
                firstp = head;
            }if(k == i){
                first = head;
            }if(k == biggerThanI){
                firstn = head;
            }
            if(k == smallerThanJ){
                lastp = head; 
            }if(k == j){
                last = head;
            }if(k == biggerThanJ){
                lastn = head;
            }
            head = head.next;
            k++;
        }
        
        firstp.next = last;
        first.next = lastn;
        if(i == smallerThanJ){
            last.next = first;
        }else{
            last.next = firstn;
        	lastp.next = first;
        }
        head = temp;
        return head; 
    }
    
}
