package PriorityQueues;

import java.util.*;
import java.io.*;

/**
 * MaxPriorityQueue
 */
public class MaxPriorityQueue {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		MaxPriorityQueue pq = new MaxPriorityQueue();
		int choice = Integer.parseInt(st.nextToken());
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = Integer.parseInt(st.nextToken());
					pq.insert(element);
					break;
				case 2 : // getMax
					System.out.println(pq.getMax());
					break;
				case 3 : // removeMax
					System.out.println(pq.removeMax());
					break;
				case 4 : // size
					System.out.println(pq.getSize());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = Integer.parseInt(st.nextToken());
		}
	}

    public ArrayList<Integer> heap;
    
	public MaxPriorityQueue() {
		heap = new ArrayList<>();
	}
	boolean isEmpty() {
		return heap.isEmpty();
	}
	int getSize() {
		return heap.size();
	}
	int getMax() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return heap.get(0);
	}
	void insert(int data) {
		heap.add(data);
		upHeapify();
	}
	int removeMax() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		downHeapify();
		return temp;
	}
	public void upHeapify() {
		int childIndex = heap.size()-1;
		while(childIndex>0) {
			int parentIndex = (childIndex - 1) /2;
			if(heap.get(parentIndex) < heap.get(childIndex) ) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex,temp);
				childIndex = parentIndex;
			}
			else {
				break;
			}
		}
		
	}
	public void downHeapify() {
		
		int parentIndex = 0;
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		int maxIndex = 0;
		while(leftChildIndex<heap.size()) {
			
			if( heap.get(leftChildIndex) >  heap.get(maxIndex) ) {
				maxIndex = leftChildIndex;
			}
			if( rightChildIndex<heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex) ) {
				maxIndex = rightChildIndex;
			}
			if(maxIndex!=parentIndex) {
				
				int temp = heap.get(maxIndex);
				heap.set(maxIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				parentIndex = maxIndex;
				leftChildIndex = 2*parentIndex + 1;
				rightChildIndex = 2* parentIndex + 2;	
			}
			else {
				break;
			}	
		}
	}

}