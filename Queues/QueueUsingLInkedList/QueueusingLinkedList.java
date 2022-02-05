package Queues.QueueUsingLInkedList;

import Queues.QueuesUsingArray.QueueEmptyException;

public class QueueusingLinkedList<T> {
    
    private QueueNode<T> front;
    private QueueNode<T> rear;
    private int size;

    public QueueusingLinkedList(){
        front = null;
        rear = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size==0;
    }

    T front() throws QueueEmptyException{
        if(front == null){
            throw new QueueEmptyException();
        }
        return front.data;
    }

    void enqueue(T element){
        if(size == 0){
            front.data = element;
        }else{
            front.next = rear;
            rear.data = element;
        }
        size++;
    }

    T dequeue() throws QueueEmptyException{
        if(size == 0) {
            throw new QueueEmptyException();
        }
        T temp = front.data;
        front = front.next;
        if(size == 1){
            rear = null;
        }
        size--;
        return temp;
    }

}
