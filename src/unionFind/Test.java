package unionFind;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
    	t_WQU();
    }
    
    
    public static void t_QuickUnionUF() {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        QuickUnionUF q = new QuickUnionUF(a.length);
        for(int i=0; i<a.length-1; i++) {
        	q.union(i, i+1);
        }
        System.out.println(q.getID());
    }
    
    public static void t_WQU() {
    	int[] a = {1,2,3,4,5,6,7};
    	WQU q = new WQU(a.length);
    	System.out.println(q.getID());
    	q.union(3, 1);
    	q.union(3, 2);
    	System.out.println(q.getID());
    }
}