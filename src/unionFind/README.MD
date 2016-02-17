#Dynamic Connectivity
* Given a set of N Objects
    * Union(a,b): Connect two Objects
    * Connected query: Is there a path connecting one object to another? (Truth value not the actual path)

##Model Objects:
* Use integers as array index
* Connected Components:
    * Suppose you have  8 nodes numbered from 0,7: the connected components would be: 
        {0} {1 4 5} {2 3 6 7}

##Operations:
* Find Query: Check if two objects are in the same component.
* Union Command: Replace components containing two objects with their union.
    * union(2,5): merge the connected components, the one containing 2 with the one
        containing 5 --> {0} {1 2 3 4 5 6 7}

##Solution:
* public class UF: contains methods: union and connected
    * UF(int N): initialize data structures based on number of objects
    * void union(int p, int q)
    * boolean connected(int p, int q)
* QuickFind 
* QuickUnion



























