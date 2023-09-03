package talgo;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @Description TODO
 */
public class Conclusion {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(maxBit(7));
    }

    /**
     * 统计正数数字中1的最高位
     * 比如7，0111，1最高位为2
     */
    public static int maxBit(int nums) {
        int max_bit = 31;
        while ((nums >> max_bit) == 0) {
            max_bit -= 1;
        }
        return max_bit;
    }

    static class Solution {

    }
}
