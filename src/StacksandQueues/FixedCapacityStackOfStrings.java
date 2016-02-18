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
		return item;
	}
}
