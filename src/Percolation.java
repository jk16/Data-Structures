import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private WeightedQuickUnionUF grid;
	private int N;
	public Percolation(int N)
	{
//		create N-by-N grid, with all sites blocked
		grid = new WeightedQuickUnionUF(N);
		
	}
	
	public void open(int i, int j) {   
//	open site (row i, column j) if it is not open already
//		if is not open
//			determine how many adjacent nodes it has
//			based on number of adjacent Nodes, use union those adj nodes
//	    else return
	}
	
	public boolean isOpen(int i, int j) {
		// is site (row i, column j) open?
		
//		getAdjNodes
//		for each adjNode
//			if node is connected to all nodes 
//				return true
		return false;
	}
	
	public List<Integer> getAdjNodes(int cNode) {
		List<Integer> adjNodes = new ArrayList<Integer>();
		int right;
		int	left;
		int	bot;
		
//		if node if on extreme left
		if(cNode%N == 0) {
			right = N+1;
			bot = cNode + N ;
			adjNodes.add(right);
			adjNodes.add(bot);
		}
//		else if node on extreme right
		else if ((cNode+1)%N == 0) {
			left = N-1;
			bot = cNode + N;
			adjNodes.add(left);
			adjNodes.add(bot);
		}
//		else node is not an extreme
		else {
			right = N+1;
			left = N-1;
			bot = cNode + N;
		}
		return adjNodes;
			
	}
	
	public WeightedQuickUnionUF getGrid() {
		return grid;
	}
	
	public int getN() {
		return N;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Percolation p = new Percolation(5);
		WeightedQuickUnionUF g = p.getGrid();
	}

}
