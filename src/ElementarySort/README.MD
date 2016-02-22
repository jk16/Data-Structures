#Elementary Sorts

##Selection Sort
* Go through every element in the array
* keep a variable min: index of the smallest element to the right of pointer i
* Inner for loop points to the right of i: 
	* j=i+1: if it finds a smaller one it resets min: min=j 
* Once youve looped through all elems to the right of i: exchange the smallest with i

##Insertion Sort
* Keep a pointer i that goes through the array
* Moving from Right to Left, exchange a[i] with entries to its left: if it is less	

##Shell Sort
* Insertion Sort works increments of 1 (call it: 1-sort), the idea behind shell sort is to do h-sorting where	
the h is going to be some sequence (determining the sequence is a problem on its own, 3x+1 is the Knuth.
* Intuition: "a g-sorted array remains g-sorted after h-sorting it" so when its partially sorted you can use insertion sort and it will be sort is faster. 