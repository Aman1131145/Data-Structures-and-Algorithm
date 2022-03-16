package PriorityQueues;

import java.util.ArrayList;

public class MinPriorityQueue {

    private ArrayList<Integer> heap;
    
    public MinPriorityQueue(){
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

    void insert(int element) {
		heap.add(element);
        upHeapify();
// 		int cI = heap.size() - 1;
// 		int i = (cI - 1) / 2;

// 		while (cI > 0) {
// 			if (heap.get(cI) < heap.get(i)) {
// 				int temp = heap.get(cI);
// 				heap.set(cI, heap.get(i));
// 				heap.set(i, temp);
// 				cI = i;
// 				i = (cI - 1) / 2;
// 			} else {
// 				return;
// 			}
// 		}
	}

	int removeMin() throws PriorityQueueEmptyException{
		// Complete this function
		// Throw the exception PriorityQueueException if queue is empty
        if(heap.isEmpty()){
            throw new PriorityQueueEmptyException();
        }
        int temp = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        downHeapify();
        return temp;
	}
    
    void downHeapify() {
		
		int i = 0;
		int lI = 2*i+1;
		int rI = 2*i+2;
		int mI = 0;
		while(lI<heap.size()) {
			
			if( heap.get(lI) < heap.get(mI) ) {
				mI = lI;
			}
			if( rI<heap.size() && heap.get(rI) < heap.get(mI) ) {
				mI = rI;
			}
			if(mI!=i) {
				
				int temp = heap.get(mI);
				heap.set(mI, heap.get(i));
				heap.set(i, temp);
				i = mI;
				lI = 2*i + 1;
				rI = 2* i + 2;	
			}
			else {
				break;
			}	
		}
	}
    public void upHeapify() {
		int cI = heap.size()-1;
		while(cI<0) {
			int i = (cI - 1) /2;
			if(heap.get(i) > heap.get(cI) ) {
				int temp = heap.get(cI);
				heap.set(cI, heap.get(i));
				heap.set(i,temp);
				cI = i;
			}
			else {
				break;
			}
		}
		
	}
}
