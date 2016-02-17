package unionFind;
import java.util.Arrays;

/*
Data Structure: http://imgur.com/v2YPmxO
    * integer array id[] of size N
    * interpretation: id[i] is parent of i

Find --> check if p and q are connected: they must have the same root
Union --> Merge components containing p and q: set id (ie tree) of q to id of p (ie tree)

Methods:
* QuickUnionUF(int N) : initialize the array and have the nodes point to themselves
* int root(int i): chase parent pointers until reach root
* boolean connected(int p, int q): if they have the same parent then they are equal
* void union(int p, int q): root of p point to root of q


*/

public class QuickUnionUF
{
        private int[] id;

        public QuickUnionUF(int N) 
        {
            id = new int[N];
            for (int i=0; i<N; i++) {
                //set id to itself
                id[i] = i;
            }
        }

        public int root(int i) {
            //
            while(i != id[i]) {
            	System.out.println("The parent of: " + i + " is: " +  id[i]);
                i = id[i];
            }
            return i;
        }

        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            id[i] = j;
        }
        
        public String getID() {
        	return Arrays.toString(id);
        }
}