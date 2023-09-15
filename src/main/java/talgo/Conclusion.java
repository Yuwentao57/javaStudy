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

    /**
     * (n - 1) & n 将n最右侧的 1 变成 0
     * @param num
     * @return
     */
    int numberOf1(int num){
        int ans = 0;
        while (num != 0) {
            ans += 1;
            num = (num - 1) & num;
        }
        return ans;
    }

    static class Solution {

    }
}
