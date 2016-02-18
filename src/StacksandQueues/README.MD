##Stacks and Queues
* Given a collection of objects
	* operations: insert/remove/iterate
	* Ambiguity: Which item do we remove?
		* stack --> removes most recently added ("last in first out")
			* push (insert)/pop (remove)
		* queue --> removes least recently added ("first in first out")
			* enqueue (insert)/dequeue(remove)
###StackOfStrings API:
	* ctor initialize empty stack
	* push: inert string onto stack
	* pop: remove and return string most recently added
	* isEmpty: is the stack empty?
	####First implementation: Keep a linked link consisting of nodes that have strings in them
		and references to the next item in the LL
		* push: insert new node at the beginning of the LL
		* pop: remove the first node from the front 

	