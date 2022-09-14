package algo;

public class LC70 {
    public static void main(String[] args) {
        System.out.println(climStair(8));
    }
    public static int climStair(int n) {
        if (n <= 2) return n;
        int a1 = 1, a2 = 1;
        for (int i = 2; i <= n; i ++) {
            int t = a1 + a2;
            a1 = a2;
            a2 = t;
        }
        return a2;
    }
}



