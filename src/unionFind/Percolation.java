package unionFind;
import java.util.Random;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private WeightedQuickUnionUF grid;
	public static int N;
	int vTop, vBot;
	public Percolation(int n)
	{	
		N = n;
		vTop = N+1;
		vBot = N+2;
		grid = new WeightedQuickUnionUF((N+1) * (N+1));
		//all nodes in the first row connected to last Node of first row
		for(int i=0;i<N; i++) {
//			System.out.println(i + "  " + (N+1));
			grid.union(i, vTop);//N=3: {0,4},{1,4}, {2,4}
			
			
//			System.out.println(coordToGridValue(vBot,i+1) +"  " + ( (N+1)*(N+1) - 1   ) );
			
			grid.union(coordToGridValue(vBot,i+1), ( (N+1)*(N+1) - 1   ) ); //N=3: {12,15},{13,15}, {14,15}
		}
		
	}
	
	public int coordToGridValue(int i, int j) {
		return (N*(i-1) + (j-1));
	}
	
	public void open(int i, int j) {   
//	open site (row i, column j) if it is not open already
//		if is not open (use isOpen method)
		boolean isNotOpen = !isOpen(i,j);
		if(isOpen(i,j))
			return;
		
//		determine how many adjacent nodes it has
		String adjNodes = getAdjNodes(j);
		if(isNotOpen) {
//			based on number of adjacent Nodes, use union those adj nodes
			
			if(adjNodes.equals(new String("right"))) {
				//union cNode with Left Node
				grid.union(coordToGridValue(i,j), coordToGridValue(i,j-1));
//				if row is not last
				if(i<N){
//					union cNode with right Node
					grid.union(coordToGridValue(i,j), coordToGridValue(i+1,j));
				}
//				if at the last row
				else if(i==N){
//					union cNode with node in second to last row
					grid.union(coordToGridValue(i,j) , coordToGridValue(i-1,j));
				}	
			}
			
			else if(adjNodes.equals(new String("left"))) {
//				union cNode with right Node
				grid.union(coordToGridValue(i,j), coordToGridValue(i,j+1));
//				if row is not the last one
				if (i<N) {
//					union cNode with node in next row same col
					grid.union(coordToGridValue(i,j), coordToGridValue(i+1,j));
				}
//				if cNode is in the last row
				else if(i==N){
//					union cNode with node in previous row same col
					grid.union(coordToGridValue(i,j), coordToGridValue(i-1,j));
				}
			}
			//Node is not in the extremes
			else {
				//union cNode with a node to the right
				grid.union(coordToGridValue(i,j) , coordToGridValue(i,j+1));
				//union cNode with a node to the left
				grid.union(coordToGridValue(i,j) , coordToGridValue(i,j-1));
//				if cNode is in row 1
				if(i==1) {
					//union cNode with node in next row same col
					grid.union(coordToGridValue(i,j) , coordToGridValue(i+1,j));
				}
//				if cNode is in the last row
				if(i==N) {
//					union cNode with node in the previous row same col
					grid.union(coordToGridValue(i,j) , coordToGridValue(i-1,j));
				}
//				if the cNode is not in the first/last row
				if(i>1 && i<N)  {
					//union cNode with node in previous row same col
					grid.union(coordToGridValue(i,j) , coordToGridValue(i-1,j));
					//union cNode with node in next row same col
					grid.union(coordToGridValue(i,j) , coordToGridValue(i+1,j));
				}
				
				
			}
			
		}
	}
	
	
	public boolean isOpen(int i, int j) {
		// is site (row i, column j) open?
//		getAdjNodes
		String adjNodes = getAdjNodes(j);
		if(adjNodes.equals(new String("right"))) {
			if(i==1){
				return 
						grid.connected(coordToGridValue(i,j), coordToGridValue(i+1,j)) && 
						grid.connected(coordToGridValue(i,j), coordToGridValue(i,j-1));
			}
			if(i==N) {
				return 
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i-1,j)) &&
						grid.connected(coordToGridValue(i,j), coordToGridValue(i,j-1));
			}
			if(i>1 && i<N) {
				return
						grid.connected(coordToGridValue(i,j), coordToGridValue(i,j-1)) &&
						grid.connected(coordToGridValue(i,j), coordToGridValue(i+1,j)) &&
						grid.connected(coordToGridValue(i,j), coordToGridValue(i-1,j));
				}
			
		}
		
		else if(adjNodes.equals(new String("left"))) {
			if (i<N) {
				return
						grid.connected(coordToGridValue(i,j), coordToGridValue(i+1,j)) && 
						grid.connected(coordToGridValue(i,j), coordToGridValue(i,j+1));
			}
			else if(i==N){
				return
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i-1,j)) &&
						grid.connected(coordToGridValue(i,j), coordToGridValue(i,j+1));
			}
		}
		else {
			if(i==1) {
				return
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i,j+1)) &&
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i,j-1)) &&
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i+1,j));
			}
			if(i==N) {
				return
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i,j+1)) &&
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i,j-1)) &&
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i-1,j));
			}
			if(i>1 && i<N) {
				return 
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i,j+1)) &&
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i,j-1)) &&
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i-1,j)) &&
						grid.connected(coordToGridValue(i,j) , coordToGridValue(i+1,j));
						
			}
		
		}
		
		return false;
	}
	
	public boolean percolates() {
		// is site (row i, column j) full?
		//the site is full when virtual nodes are connected
		System.out.println("perculates: " + grid.connected(0, N*N));
		return grid.connected(vTop, vBot);
	} 
	
	public String getAdjNodes(int col) {
		String typeOfCoord = null;
		
//		if node if on extreme left ie (something,1)
		if(col == 1) {
			typeOfCoord = new String("left");
		}
//		else if node on extreme right
		else if (col == N ) {
			typeOfCoord = new String("right");
		}
//		else node is not an extreme
		else {
			typeOfCoord = new String("center");
		}
		return typeOfCoord;
			
	}
	
	public WeightedQuickUnionUF getGrid() {
		return grid;
	}
	
	public int getN() {
		return N;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 3;
		Percolation p = new Percolation(N); //go from (0,N-1) N: Top, N+1 will be bottom
		/*
		WeightedQuickUnionUF g = p.getGrid();
		int i,j;
		System.out.println(p.getN());
		boolean booleanPercolates = false;
		int c=0;
//		Repeat the following until the system percolates:
		while (!booleanPercolates) {
			i = StdRandom.uniform(1, N + 1);
			j = StdRandom.uniform(1, N + 1);
//			Choose a site (row i, column j) uniformly at random among all blocked sites.
			if( !p.isOpen(i, j) ) {
				p.open(i, j);
				booleanPercolates = p.percolates();
				c+=1;
			}
		}
		System.out.println(c);
		*/
	}

}
