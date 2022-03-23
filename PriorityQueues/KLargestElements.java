package PriorityQueues;

import java.util.*;

public class KLargestElements {
    static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = KLargestElements.kLargest(input, k);
		for(int i : output) {
			System.out.println(i);
		}
		
	}

    public static ArrayList<Integer> kLargest(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            pq.add(input[i]);
        }
        for(int i = k; i < input.length; i++){
            if(input[i] > pq.peek()){
                pq.poll();
                pq.add(input[i]);
            }
        }
		ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list;
	}    
}
