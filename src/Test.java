public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        QuickUnionUF q = new QuickUnionUF(a.length);
        System.out.println(q.toString());
//        System.out.println(q.root(1));
    }
}