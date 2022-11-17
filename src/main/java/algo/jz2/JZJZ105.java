package algo.jz2;

import java.util.Arrays;

public class JZJZ105 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }
        Union union = new Union(a);
        for (int i = 1; i < 10; i++) {
            union.joinPoint(0, i);
        }
        System.out.println(Arrays.toString(a));
    }
}


class Union {
    int[] a;

    public Union(int[] a) {
        this.a = a;
    }

    private int findRoot(int p) {
        while (a[p] != p) p = a[p];
        return p;
    }

    public int joinPoint(int p1, int p2) {
        int root1 = findRoot(p1);
        int root2 = findRoot(p2);
        if (root1 == root2) return root1;
        while (a[p2] != root2) {
            a[p2] = root1;
            p2 = a[p2];
        }
        a[root2] = root1;
        return root1;
    }
}

