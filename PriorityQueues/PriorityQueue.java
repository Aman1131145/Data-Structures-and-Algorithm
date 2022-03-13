package PriorityQueues;

import java.util.ArrayList;

public class PriorityQueue {

    private ArrayList<Integer> heap;
    
    public PriorityQueue(){
        heap = new ArrayList<>();
    }

    boolean isEmpty(){
        return heap.size() == 0;
    }
    
    int size(){
        return heap.size();
    }

    int getMin() throws PriorityQueueEmptyException{
        if(isEmpty()) {
            // Throw an exception
            throw new PriorityQueueEmptyException();
        }
        return heap.get(0);
    }
    
    void insert(int element){
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while(childIndex > 0){
            if(heap.get(childIndex) < heap.get(parentIndex)){
                int temp = heap.get(childIndex);
                heap.set(childIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);
                parentIndex = (childIndex - 1)/2;
            }else{
                return;
            }
        }
    }
}
