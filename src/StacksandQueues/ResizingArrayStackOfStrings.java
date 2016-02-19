package StacksandQueues;

public class ResizingArrayStackOfStrings {
	String[] s;
	private int N = 0;
	
	public ResizingArrayStackOfStrings() {
		s = new String[1];
	}
	
	public void push(String item) {
//		if items in stack same as size of array
		if (N == s.length)
//			resize the array of one twice the length before insert
			resize(2*s.length);
		s[N++] = item;
	}
	
	public String pop() {
		String item = s[--N];
		s[N] = null;
		if(N>0 && N==s.length/4)
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
