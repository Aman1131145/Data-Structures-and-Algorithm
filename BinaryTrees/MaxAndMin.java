package BinaryTrees;

import java.io.*;

class QueueEmptyException extends Exception {

}

 class QueueUsingLL<T> {

	class MinMaxNode<V> {
		T data;
		MinMaxNode<T> next;
		MinMaxNode(T data){
			this.data = data;
		}
	}
	
	private MinMaxNode<T> head;
	private MinMaxNode<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		MinMaxNode<T> newMinMaxNode = new MinMaxNode<T>(element);

		if(head == null){
			head = newMinMaxNode;
			tail = newMinMaxNode;
		}
		else{
			tail.next = newMinMaxNode;
			tail = newMinMaxNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}


class MinMaxNode<T> {
	T data;
	MinMaxNode<T> left;
	MinMaxNode<T> right;

	public MinMaxNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class maxMinPair<T, U> {
	T minimum;
	U maximum;

	public maxMinPair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}

public class MaxAndMin {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static MinMaxNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<MinMaxNode<Integer>>  pendingMinMaxNodes = new QueueUsingLL<MinMaxNode<Integer>>(); 
		int start = 0;

		String[] MinMaxNodeDatas = br.readLine().trim().split(" ");

		if (MinMaxNodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(MinMaxNodeDatas[start]);
		start += 1;

		MinMaxNode<Integer> root = new MinMaxNode<Integer>(rootData);
		pendingMinMaxNodes.enqueue(root);

		while(!pendingMinMaxNodes.isEmpty()){
			MinMaxNode<Integer> currentMinMaxNode;
			try {
				currentMinMaxNode = pendingMinMaxNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(MinMaxNodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				MinMaxNode<Integer> leftChild = new MinMaxNode<Integer>(leftChildData);
				currentMinMaxNode.left = leftChild;
				pendingMinMaxNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(MinMaxNodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				MinMaxNode<Integer> rightChild = new MinMaxNode<Integer>(rightChildData);
				currentMinMaxNode.right = rightChild;
				pendingMinMaxNodes.enqueue(rightChild);
			}
		}

		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		MinMaxNode<Integer> root = takeInput();
		
		maxMinPair<Integer, Integer> maxMinPair = MaxAndMin.getMinAndMax(root);
		System.out.println(maxMinPair.minimum + " " + maxMinPair.maximum);
		
	}

    static maxMinPair<Integer,Integer> output = new maxMinPair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
    public static maxMinPair<Integer, Integer> getMinAndMax(MinMaxNode<Integer> root) {
		//Your code goes here
        getMinAndMaxHelper(root);
        return output;
    }
    public static void getMinAndMaxHelper(MinMaxNode<Integer> root) {
		//Your code goes here
        if(root == null){
            return;
        }
        int maxVal = output.maximum;
        int minVal = output.minimum;
        if(root.data>maxVal){
            output.maximum = root.data;
        }
        if(root.data<minVal){
            output.minimum = root.data;
        }
        getMinAndMaxHelper(root.left);
        getMinAndMaxHelper(root.right); 
    }
}
