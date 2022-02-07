package Test2;

import java.util.Scanner;

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.setData(data);
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

public class DeleteAlternateNodes {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        Node<Integer> list = input();
        DeleteAlternateNodes.deleteAlternateNodes(list);
        print(list);
    }

    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.next;
        }
    }

    public static Node<Integer> input() {
        int data = s.nextInt();

        Node<Integer> head = null;
        Node<Integer> tail = null;
        while (data!=-1) {
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void deleteAlternateNodes(Node<Integer> head) {
        //Your code goes here
        if (head == null){
            System.out.println();
        }

        Node<Integer> temp = head;
        while(head.next != null && head != null){
            head.next = head.next.next;
            head = head.next;
            if(head.next.next == null){
                head.next = null;
                head = temp;
                break;
            }
        }
        
    }

}
