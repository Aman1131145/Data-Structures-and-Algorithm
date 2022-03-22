package PriorityQueues;

import java.util.*;

class MinPQComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2){
        if(o1 < o2){
            return -1;
        }else if(o1 > o2){
            return 1;
        }
        return 0;
    }
}

class MaxPQComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2){
        if(o1 > o2){
            return -1;
        }else if(o1 < o2){
            return 1;
        }
        return 0;
    }
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2){
        if(o1.length() < o2.length()){
            return -1;
        }else if(o1.length() > o2.length()){
            return 1;
        }else{
            return 0;
        }
    }
}

public class PriorityQueueUse {

    public static void main(String[] args) {

        String arr[] = {"this", "at", "a", "their", "queues"};
        // StringLengthComparator stringComparator = new StringLengthComparator();
        // PriorityQueue<String> pqString = new PriorityQueue<>(stringComparator);
        // MinPQComparator minPQComparator = new MinPQComparator();
        // MaxPQComparator maxPQComparator = new MaxPQComparator();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(maxPQComparator); 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        // int arr[] = {2,4,1,9,6,8};
        // int k = 3;
        // sortKSorted(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
            
        }
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int arr[] = {9,1,0,4,7,3};
        // for (int i = 0; i < arr.length; i++) {
        //     pq.add(arr[i]);//adds the elements in the priority queue

        // }
        // System.out.println(pq.element());
        while (!pq.isEmpty()) {
            //it removes and returns the element
            System.out.println(pq.remove() + " ");
        }
    }

    public static void sortKSorted(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        for (; i < arr.length; i++) {
            arr[i-k]=pq.remove();
            pq.add(arr[i]);
        }
        for (int j = arr.length-k; j < arr.length; j++) {
            arr[j] = pq.remove();
        }
    }
}