package prog9_3_soln;

import java.util.Arrays;

public class ArrayQueueImpl {
	private int[] arr = new int[10];
	private int size = 0;
	//front is < 0 until first element is enqueued; 
    //after that it is always >= 0
	private int front = -1;
	private int rear = 0;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int peek() {
		if(isEmpty()) throw new IllegalStateException(
				"Cannot peek because Queue is empty!");
		else return arr[front];
	}
	
	public int dequeue() {
		if(isEmpty()) throw new IllegalStateException(
				"Cannot dequeue because Queue is empty!");
		int retVal = arr[front++];
		size--;
		return retVal;
	}
	
	public void enqueue(int r) {
		if(front == -1) ++front;
		if(rear == arr.length) {
			resize();
		}
		arr[rear++] = r;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	private void resize() {
		int[] temp = new int[arr.length * 2];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		arr = temp;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		for(int i = front; i < rear; ++i) {
			sb.append(arr[i] + " ");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();
		q.enqueue(1);
		q.dequeue();
		System.out.println(q);
				   
		
		
		/*
		q.enqueue(100);q.enqueue(101);q.enqueue(102);
		System.out.println("State of background array after adding 100, 101, 102:\n  " 
		   + Arrays.toString(q.arr));
		System.out.println("After adding 100, 101, 102, values of front and rear:\n  " 
		   + q.front + ", " + q.rear);
		System.out.println("After adding 100, 101, 102, here is the queue:\n  " + q);
		q.dequeue();q.dequeue();q.dequeue();
		System.out.println("Empty after 3 dequeues? " + q.isEmpty());
		for(int i = 0; i < 15; i ++)
			q.enqueue(i);
		for(int i = 0; i < 14; i ++)
			q.dequeue();
		System.out.println("After 15 enqueues and 14 dequeues, size is: " + q.size());
		System.out.println("After 15 enqueues and 14 dequeues, front value is " + q.peek());
		*/
	}
}
