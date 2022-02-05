package Queues.QueueUsingLInkedList;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        Queue<Integer> queue  = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.poll());
        System.out.println(queue.size());        
        System.out.println(queue.peek());
        queue.isEmpty();
    }
}
