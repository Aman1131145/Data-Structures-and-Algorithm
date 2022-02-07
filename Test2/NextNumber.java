package Test2;

import java.util.Scanner;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
}
public class NextNumber {
	static Scanner s = new Scanner(System.in);

	public static LinkedListNode<Integer> takeInput() {
		LinkedListNode<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		
		LinkedListNode<Integer> head = takeInput();
		head = NextNumber.nextLargeNumber(head);
		print(head);
		
	}

    static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> prev = null;
        while(current != null){
            LinkedListNode<Integer> temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
    /* First reverse the number, add 1 to it and traverse it for carry to travel till the
    most significant digit and then if carry exists, append to linked list and reverse again
    to get final result
    */
    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        head = reverse(head);
        int carry =1,num;
        LinkedListNode<Integer> ptr=head, prev=null;
        while(ptr != null){
            num = ((ptr.data)+carry)%10;
            carry = ((ptr.data)+carry)/10;
            ptr.data = num;
            prev=ptr;
            ptr = ptr.next;
        }
        if(carry == 1){
            LinkedListNode<Integer> tail = new LinkedListNode<Integer>(carry);
            prev.next = tail;
        }
        return reverse(head);
    }
}
