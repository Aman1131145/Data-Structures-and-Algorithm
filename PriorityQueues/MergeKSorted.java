package PriorityQueues;

import java.io.*;
import java.util.*;

class PairComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        if(p1.value <= p2.value){
            return 1;
        }else{
            return -1;
        }
    }
}
class Pair {
    int value;
    int arrayNumber;
    Pair(int v, int n) {
        value = v;
        arrayNumber = n;
    }
}
public class MergeKSorted {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }




	public static void main(String[] args) throws IOException {
		int k = Integer.parseInt(br.readLine().trim());
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		while(k > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			ArrayList<Integer> current = new ArrayList<Integer>();
            String[] strNums;
            strNums = br.readLine().split("\\s");
            for(int i = 0; i < n; i++) {
				current.add(Integer.parseInt(strNums[i]));
			}
			input.add(current);
			k--;
		}
        ArrayList<Integer> output = MergeKSorted.mergeKSortedArrays(input);
        if (output!=null){
            for(int i : output) {
                System.out.print(i + " ");
            }
        }

	}

    
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
        if (input.size()==0){
            return null;
        }
        PairComparator compare = new PairComparator();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(input.size(),
        compare);
        for(int i = 0; i < input.size(); i++) {
            int index = input.get(i).size() - 1;
            Pair current = new Pair(input.get(i).get(index), i);
            maxHeap.add(current);
            input.get(i).remove(index);
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        while(!maxHeap.isEmpty()) {
            Pair max = maxHeap.remove();
            output.add(max.value);
            int i = max.arrayNumber;
            if(input.get(i).size() > 0) {
                int index = input.get(i).size() - 1;
                int value = input.get(i).get(index);
                input.get(i).remove(index);
                Pair current = new Pair(value, i);
                maxHeap.add(current);
            }
        }
        Collections.reverse(output);
        return output;
    }
    
}
