package sortalgo;

import java.util.Arrays;

/**
 * @Description TODO
 */
public class QuickSort {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {2,3,1,7,4,5,8,0};
        solution.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    static class Solution {


        public void quickSort(int[] arr, int start, int end) {
            if (start >= end) {
                return;
            }
            int pos = partition(arr, start, end);
            quickSort(arr, start, pos - 1);
            quickSort(arr, pos + 1, end);
        }

        private int partition(int[] arr, int l, int r) {
            int swap_pos = l + 1;
            for (int i = swap_pos; i < r + 1; i++) {
                if (arr[l] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[swap_pos];
                    arr[swap_pos] = temp;
                    swap_pos += 1;
                }
            }
            swap_pos -= 1;
            int temp = arr[l];
            arr[l] = arr[swap_pos];
            arr[swap_pos] = temp;
            return swap_pos;
        }
    }
}
