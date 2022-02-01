package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EAO<T> {
    T data;
    EAO<T> next;
    
    public EAO(T data) {
        this.data = data;
    }
}

public class EvenAfterOdd {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static EAO<Integer> takeInput() throws IOException {
        EAO<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            EAO<Integer> newNode = new EAO<Integer>(data);
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
    
    public static void print(EAO<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            EAO<Integer> head = takeInput(); 

            EAO<Integer> newHead = EvenAfterOdd.evenAfterOdd(head);
            print(newHead);

            t -= 1;
        }

    }

    public static EAO<Integer> evenAfterOdd(EAO<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }
		EAO<Integer> evenhead = null,oddhead = null, oddtail = null , eventail = null;
        while(head != null){
            if(head.data%2 == 0){
                if(evenhead == null){
                    evenhead = head;
                    eventail = head;
                }else{
                    eventail.next = head;
                	eventail = eventail.next;
                }
            }else{
                if(oddhead == null){
                    oddhead = head;
                    oddtail = head;
                }else{
                  	oddtail.next = head;
                   	oddtail = oddtail.next; 
                }
            }
            head = head.next;
        }
        if(oddhead == null){
            return evenhead;
        }if(evenhead == null){
            return oddhead;
        }
        oddtail.next = evenhead;
        eventail.next = null;
        return oddhead;
    }
    
}
