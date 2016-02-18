package StacksandQueues;

public class FixedCapacityStackOfStrings {
	private String[] s;
	private int N = 0;
	
//	ctor creates array
//	cheat: most of the time client doesnt know size of stack!
//	Q: how do you remove?
	public FixedCapacityStackOfStrings(int capacity) {
		s = new String[capacity];
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void push(String item) {
		s[N++] = item;
	}
	
	public String pop() {
//		Underflow: throw exception if pop from an empty stack
//		reference still exists so the java-garbage collector wont deal with it
//		return s[--N];
//		fix:
		String item = s[--N];
		s[N] = null;
//		halve size of array when array is 1/4 full
		if (N>0 && N == s.length/4) 
			resize(s.length/2);
		return item;
	}
	
	public void resize(int capacity) {
		//create new array of that capacity
		String[] copy = new String[capacity];
		for(int i=0; i<N; i++) 
			//copy stack onto this array
			copy[i] = s[i];
		s = copy;
	}
}
