package algo;

import java.util.Arrays;

public class LC28 {

    public static void main(String[] args) {
        String n = "ABCDABD";
        System.out.println(Arrays.toString(Solution28.getNext(n)));
    }

}

class Solution28 {
    public int strStr(String haystack, String needle) {
        return 0;
    }


    public static int[] getNext(String needle) {
        int len = needle.length();
        int[] next = new int[len];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < len - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
