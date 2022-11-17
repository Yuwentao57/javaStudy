package algo.find;

public class BinaryFind {
    /**
     * 返回有序数组arr中，该元素的位置；如果无法查找到
     * 则返回该元素应该插入的位置——pos，
     * pos可能为 0, [0, arr.len - 1], arr.len
     * @param a
     * @param ele
     * @return
     */
    public int binaryFind(int[] a, int ele) {
        int l = 0;
        int r = a.length - 1;
        int mid = l;
        while (l <= r) {
            mid = (l + r) / 2;
            if (a[mid] == ele) {
                return mid;
            } else if (a[mid] < ele) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
