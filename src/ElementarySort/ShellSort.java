package ElementarySort;

import java.util.Arrays;

public class ShellSort {

	public static void sort(Comparable[] a) {
		int N = a.length;
		
		int h = 1;
		while(h<N/3) h=3*h+1;
		
		while(h>=1) {
			//h-sort the array
			for(int i=h; i<N; i++) {
				for(int j=i; j>=h && less(a[j], a[j-h]); j-=h)
					exch(a, j, j-h);	
			}
			
			h=h/3;
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	private static boolean less(Comparable v, Comparable w) {
	    return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
	    Comparable swap = a[i];
	    a[i] = a[j];
	    a[j] = swap;
	}
	
	public static void main(String[] args) {
		  Comparable[] list = new Comparable[10];
		  for (int i=9; i>=0; i--) {
			  list[i] = Integer.valueOf(10-i);
		  }
//		  System.out.println(Arrays.toString(list));
		  sort(list);
	}

}
