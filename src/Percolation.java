import java.util.Random;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private WeightedQuickUnionUF grid;
	private int N, vBot, vTop;
	public Percolation(int N)
	{
//		create N-by-N grid, with all sites blocked
//		N+2 is to have the top/bottom virtual nodes
//			N: Top and N+1: bottom
		
		grid = new WeightedQuickUnionUF(N+2);
		vTop = N;
		vBot = N+1;
		for (int i=1; i<=N; i++) {
			grid.union(vTop, i);
			grid.union(i, vBot);
		}
		
	}
	
	public int coordToGridValue(int i, int j) {
		return (N*(i-1) + (j-1));
	}
	
	public void open(int i, int j) {   
//	open site (row i, column j) if it is not open already
//		if is not open (use isOpen method)
		boolean isNotOpen = !isOpen(i,j);
//		determine how many adjacent nodes it has
		String adjNodes = getAdjNodes(j);
		if(isNotOpen) {
//			based on number of adjacent Nodes, use union those adj nodes
			if(adjNodes.equals(new String("right"))) {
				//left Node
				grid.union(coordToGridValue(i,j), coordToGridValue(i,j-1));
				if(i<N){
					grid.union(coordToGridValue(i,j), coordToGridValue(i+1,j));
				}
				else if(i==N)
					grid.union(coordToGridValue(i,j) , coordToGridValue(i-1,j));
			}
			
			else if(adjNodes.equals(new String("left"))) {
				//right Node
				grid.union(coordToGridValue(i,j), coordToGridValue(i,j+1));
				if (i<N) {
					grid.union(coordToGridValue(i,j), coordToGridValue(i+1,j));
				}
				else if(i==N){
					grid.union(coordToGridValue(i,j), coordToGridValue(i-1,j));
				}
			}
			else {
				//right
				grid.union(coordToGridValue(i,j) , coordToGridValue(i,j+1));
				//left
				grid.union(coordToGridValue(i,j) , coordToGridValue(i,j-1));
				
				if(i==1) {
					grid.union(coordToGridValue(i,j) , coordToGridValue(i+1,j));
				}
				
				if(i==N) {
					grid.union(coordToGridValue(i,j) , coordToGridValue(i-1,j));
				}
				
				if(i>1 && i<N)  {
					grid.union(coordToGridValue(i,j) , coordToGridValue(i+1,j));
					grid.union(coordToGridValue(i,j) , coordToGridValue(i-1,j));
				}
				
				
			}
			
		}
			


//	    else return
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
		System.out.println("perculates!");
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
		Percolation p = new Percolation(3); //go from (0,N-1) N: Top, N+1 will be bottom
		WeightedQuickUnionUF g = p.getGrid();
		int i,j;
		
		Random rand = new Random();
//		Repeat the following until the system percolates:
		while (!p.percolates()) {
//			Choose a site (row i, column j) uniformly at random among all blocked sites.
			i = rand.nextInt(p.getN()*p.getN());
			j = rand.nextInt(p.getN()*p.getN());
//			Open the site (row i, column j).
			p.open(i, j);
		}
	}

}
