package StacksandQueues;

public class LinkedStackOfStrings {
	private Node first = null;
	
	private class Node
	{
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		//is the first null?
		return first == null;
	}
	
	public void push(String item) {
//		add new node at the start of LL
		Node oldfirst = first;
//		create new node that will be the new node we put a the beggining 
		first = new Node();
//		set instance variables of the new node
		first.item = item;
//		old first item of the list after the new inserted node
		first.next = oldfirst;
	}
	
	public String pop() {
//		save item to return
		String item = first.item;
//		delete first Node
		first = first.next;
//		return saved item
		return item;
	}
}
