package algo;

public class LC371 {


}


class Solution371 {
    /**
     * 两数相加，不使用加号，还是看题解吧
     *
     */
    public int getSum(int a, int b) {
        while (b !=0 ) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
