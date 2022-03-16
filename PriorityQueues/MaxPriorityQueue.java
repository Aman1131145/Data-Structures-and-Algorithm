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
		int cI = heap.size()-1;
		while(cI>0) {
			int i = (cI - 1) /2;
			if(heap.get(i) < heap.get(cI) ) {
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
	public void downHeapify() {
		
		int i = 0;
		int lI = 1;
		int rI = 2;
		int mI = 0;
		while(lI<heap.size()) {
			
			if( heap.get(lI) >  heap.get(mI) ) {
				mI = lI;
			}
			if( rI<heap.size() && heap.get(rI) > heap.get(mI) ) {
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

}