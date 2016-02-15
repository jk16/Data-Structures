import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        QuickUnionUF q = new QuickUnionUF(a.length);
        for(int i=0; i<a.length-1; i++) {
        	q.union(i, i+1);
        }
        q.union(a.length-2, a.length-1);
    }
}