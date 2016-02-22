package ElementarySort;

import java.util.Arrays;

public class Selection 
{
	public static void sort(Comparable[] a) {
			int N = a.length;
			for (int i=0; i<N; i++) {
				int min = i;
				for (int j=i+1; j<N; j++)
					if (less(a[j], a[min]))
						min = j;
				exch(a, i, min);
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
		  System.out.println(Arrays.toString(list));
		  sort(list);
	  }
}
