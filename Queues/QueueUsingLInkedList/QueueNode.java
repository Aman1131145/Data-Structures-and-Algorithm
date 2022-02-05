package Queues.QueueUsingLInkedList;

public class QueueNode<T> {

    T data;
    QueueNode<T> next;

    QueueNode(T data){
        this.data = data;
        next = null;
    }
    
}
