package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ReverseI<T> {
	T data;
	ReverseI<T> next;
	
	public ReverseI(T data) {
		this.data = data;
	}
}
/**
 * ReverseLinkedListItratively
 */
public class ReverseLinkedListItratively {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static ReverseI<Integer> takeInput() throws IOException {
        ReverseI<Integer> head = null, tail = null;
        StringTokenizer tk = new StringTokenizer(br.readLine());
		int data = Integer.parseInt(tk.nextToken());
		while(data != -1) {
			ReverseI<Integer> newNode = new ReverseI<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = Integer.parseInt(tk.nextToken());
		}
		return head;
	}
	
	public static void print(ReverseI<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine().trim());
        while (t != 0){
            ReverseI<Integer> head = takeInput();
            ReverseI<Integer> ans = ReverseLinkedListItratively.reverse_I(head);
            print(ans);

            t--;
        }

	}

    public static ReverseI<Integer> reverse_I(ReverseI<Integer> head) {
        
        ReverseI<Integer> curr = head, prev = null, temp;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}