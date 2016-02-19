package StacksandQueues;

import java.util.Arrays;

public class ArrayQueueOfStrings {
	String[] q;
	int tail, head;
	private int N = 0; //number of items in q
	
	public ArrayQueueOfStrings() 
	{
		tail = 0;
		head = 0;
		q = new String[1];
	}
	
	public void enqueue(String item) {
		if(N == q.length) {
			//will return an array with values at the end, ex: [null,3,2,1]
			resize(2*q.length);
			//after resize: [null,null,2,1] so we gota recalc head/tail
			head = q.length - N - 1;
			tail = q.length - 1;
			//point head to item
			q[head] = item;
			//increment the number of objects in q
			N += 1;
		}
		//not dealing with any array sizes
		else {
//			recalc head and tail
			head = q.length - N - 1;
			tail = q.length - 1;
			q[head] = item;
			N += 1;
		}
	}
	
	public void resize(int capacity) {
		/*
		 [2,1] --> [null,null,2,1]
		 set head = len(copy) - N - 1
		 */
		String[] copy = new String[capacity];
		for(int i=0; i<N; i++) {
			copy[i+N] = q[i];
		}
		q = copy;
	}
	
	public String dequeue() {
		if(N==q.length/2)
			shrink(q.length/2);
		head = q.length - N;
		tail = q.length - 1;
		String removed = q[head];
		q[head] = null;
		N-=1;
		return removed;
		
	}
	
	public void shrink(int c) {
		String[] copy = new String[c];
		for(int i=N;i>0; --i) {
			copy[N-i] = q[q.length -i];
		}
		q = copy;
	}
	
	public void printQueue() {
		System.out.println("print q = "+ Arrays.toString(q));
	}
	
	public static void main(String[] args) {
		ArrayQueueOfStrings a = new ArrayQueueOfStrings();
//		System.out.println("HEY");
		a.enqueue("1");
		a.enqueue("2");
		a.enqueue("3");
//		a.printQueue();
		a.enqueue("4");
//		a.enqueue("5");
		a.dequeue();
		a.dequeue();
//		a.dequeue();
		a.printQueue();
	}
	
}
