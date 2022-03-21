package PriorityQueues;

import java.util.*;

public class PriorityQueueUse {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[] = {9,1,0,4,7,3};
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);//adds the elements in the priority queue

        }
        // System.out.println(pq.element());
        while (!pq.isEmpty()) {
            //it removes and returns the element
            System.out.println(pq.remove() + " ");
        }
    }
}