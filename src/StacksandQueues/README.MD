##Stacks and Queues
* Given a collection of objects
	* operations: insert/remove/iterate
	* Ambiguity: Which item do we remove?
		* stack --> removes most recently added ("last in first out")
			* push (insert)/pop (remove)
		* queue --> removes least recently added ("first in first out")
			* enqueue (insert)/dequeue(remove)

###StackOfStrings API
* ctor initialize empty stack
* push: insert string onto stack
* pop: remove and return string most recently added
* isEmpty: is the stack empty?

####First implementation
* Keep a linked link consisting of nodes that have strings in them and references to the next item in the LL
* push: insert new node at the beginning of the LL
* pop: remove the first node from the front 

####Second implementation
* Use an array
* Keep n-items on a stack
* push: add new item at s[n]
* pop: remove from s[n-1]
* Defect: Initialize the size of array limits the capacity
* Problem: Most of the time client doesnt know size of the stack, how do you grow and shrink an array?

###QueueOfStrings API
* ctor: create empty queue
* enqueue: insert new string
* dequeue: remove and return most recently added
* isEmpty: is the queue empty?

####First Implementation
* using a LL keep a pointer to the first and last nodes
* insert at the end of the LL
* remove from the front of the LL

####Second Implementation
* using an array
	* tail --> oldest added
	* head --> most recent added
* enqueue: insert to the left of most recently added
* dequeue: remove most recently added and return that item
* extra: add array resizing

	