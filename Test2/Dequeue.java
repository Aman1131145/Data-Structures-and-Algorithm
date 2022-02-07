package Test2;

public class Dequeue {
    // Complete this class
    int arr[];
    int front;
    int rear;
    int size;
    Dequeue(int size)
    {
        front = -1;
        rear = 0;
        this.size = size;
        arr = new int[size];
    }
    Dequeue(){
        front = -1;
        rear = 0;
        this.size = 10;
        arr = new int[size];
    }
    
    //Checks whether deque is full or not.
    boolean isFull()
    {
    // used % operator is insertion and deletion is in circular manner
        return (front == (rear+1)%size);
    }
    //Checks whether Deque is empty or not.
    boolean isEmpty ()
    {
        return (front == -1);
    }
    // Inserts an element at front
    void insertFront(int input)
    {
        if (isFull())
        {
            System.out.println(-1);
            return;
        }
        if (front == -1)
        {
            front = 0;
            rear = 0;
        } else {
        // used % operator is insertion is in circular manner
            front = ((front-1)%size+size)%size;
        }
        arr[front] = input ;
    }
    // function to inset element at rear end of Deque.
    void insertRear(int input)
    {
        if (isFull())
        {
            System.out.println(-1);
            return;
        }
        if (front == -1)
        {
            front = 0;
            rear = 0;
        } else {
        // used % operator is insertion is in circular manner
            rear = (rear+1)%size;
        }
        arr[rear] = input;
    }
    // Deletes element at front end of Deque
    void deleteFront()
    {
        if (isEmpty())
        {
            System.out.println(-1);
            return ;
        }
        if (front == rear)
        {
            front = -1;
            rear = -1;
        }
        else {
            // used % operator is deletion is in circular manner
            front = (front+1)%size;
        }
    }
    // Delete element at rear end of Deque
    void deleteRear()
    {
        if (isEmpty())
        {
            System.out.println(-1);
            return ;
        }
        if (front == rear)
        {
            front = -1;
            rear = -1;
        } else {
        // used % operator is deletion is in circular manner
            rear = ((rear-1)%size+size)%size;
        }
    }
    // Returns front element of Deque
    int getFront()
    {
        if (isEmpty())
        {
            return -1 ;
        }
        return arr[front];
    }
    // function return rear element of Deque
    int getRear()
    {
        if(isEmpty() || rear < 0)
        {
            return -1 ;
        }
        return arr[rear];
    }
}