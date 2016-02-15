import java.util.Arrays;

/*
 Weighted Quick Union:
 * Balance by linking root of smaller tree to root of the larger tree
 * Keep track of the size of each tree and then well maintain balance by
 	by linking the root of the smaller tree to the root of the larger tree.
 
 Data Structure:
 	* Same as QuickUnion
 	* use an array sz[i] to keep track of size of tree
 
 Find --> check if p and q are connected: they must have the same root
 Union --> root of smaller tree set to the root of larger tree
 
 Methods:
 * same as QU: ctor, connected, root
 * addition to union method: using sz[] place smaller tree as child of larger tree
 
 Path compression (aka flattening a tree):
 After getting the root of p, set the id of each examined node to point to the root.
 */
public class WQU {
	
	private int[] id;
	private int[] sz;
	
	public WQU(int N)
	{
		id = new int[N];
		sz = new int[N];
		for (int i=0; i<N; i++) {
             //set id to itself
             id[i] = i;
             sz[i] = 1;
		}
	}
	
    public int root(int i) {
        //
        while(i != id[i]) {
//        	System.out.println("The parent of: " + i + " is: " +  id[i]);
        	id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
    	//difference between QU and W-QU
        int i = root(p);
        int j = root(q);
        if (i==j) return;
//        if i has less objects than j
        if(sz[i] < sz[j]) {
        	//root of i point to root of j
        	id[i] = j;
//        	set number of objects of j to itself + objects in i
        	sz[j] += sz[i];
        }
//        other way around
        else {
        	id[j] = i;
        	sz[i] += sz[j];
        }
    }
    
    public String getID() {
    	return Arrays.toString(id);
    }
	
	
	
	
	
	
	
}










