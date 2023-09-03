package talgo;

/**
 * @Description TODO
 */
public class JZ11 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    class Solution2 {
        /**
         *
         * @param numbers
         * @return
         */
        public int minArray(int[] numbers) {
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                int m = (i + j) / 2;
                if (numbers[m] > numbers[j]) i = m + 1;
//                没必要限制太死，在无法确定具体的区间时，完全可以暴力
//                比如，如果限制numbers[m] >= numbers[j]，那么1,3,3。而这种可以交给下面for暴力
                else if (numbers[m] < numbers[j]) j = m;
                else {
                    int x = i;
                    for(int k = i + 1; k < j; k++) {
                        if(numbers[k] < numbers[x]) x = k;
                    }
                    return numbers[x];
                }
            }
            return numbers[i];
        }
    }


    static class Solution {
        public int minArray(int[] numbers) {
            int l = 0, r = numbers.length - 1;
            while (numbers[l] >= numbers[r]) {
                if (r - l == 1) {
                    l = r;
                    break;
                }
                int mid = (l + r) >> 1;
                if (numbers[mid] == numbers[l] && numbers[mid] == numbers[r]) {
                    while (l < r && numbers[l] >= numbers[l + 1]) l += 1;
                    break;
                }
                if (numbers[mid] >= numbers[l]) {
                    l = mid;
                } else if (numbers[mid] <= numbers[r]) {
                    r = mid;
                }
            }
            return numbers[l];
        }
    }
}
