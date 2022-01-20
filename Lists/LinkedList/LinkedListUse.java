package Lists.LinkedList;

import java.util.Scanner;

public class LinkedListUse
{

    
    public static Node<Integer> takeInput()
    {
        Scanner s = new Scanner(System.in);
        Node<Integer> head = null, tail = null;

        int data = s.nextInt();

        while(data != -1)
        {
            Node<Integer> newNode = new Node<Integer>(data);
            if(head == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                /**
                 * this code gives time complexity of O(n^2)
                 */
                // Node<Integer> temp = head;
                // while(temp.next != null)
                // {
                //     temp = temp.next;
                // }
                // temp.next = newNode;
                /**
                 * this tail thing reduces the time complexity to O(n)
                 */
                tail.next = newNode;
                tail = newNode; // tail = tail.next; same hai dono
            }
            data = s.nextInt();
        }
        s.close();
        return head;
    }

    public static void print(Node<Integer> head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
        
    }
    public static void main(String[] args) 
    {
        Node<Integer> head = takeInput();
        print(head);
        // Node<Integer> node1 = new Node<>(10);
        // Node<Integer> node2 = new Node<>(20);
        // Node<Integer> node3 = new Node<>(30);

        // node1.next = node2;
        // node2.next = node3;

        // Node<Integer> head = node1;
        // print(head);
        // print(head);
    }   
}