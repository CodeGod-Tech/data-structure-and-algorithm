package search;

/**
 * 二分查找
 *
 * 时间复杂度 O(logn)
 *
 * 假设数据长度为n, 每次查找数据范围都会缩小一半
 * n n/2 n/4 ...... n/2^k
 * 当2^k / n = 1时，k = logn
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] a = {1, 4, 5, 7, 20, 40, 100};
//        int result = bsearch(a, a.length, 40);
        int result = bsearch(a, 0, a.length - 1, 100);
        System.out.println("result is " + result);
    }

    /**
     * 二分查找循环实现
     */
    public static int bsearch(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) { //注意是<=
//            int mid = (high + low) /2; //如果low和high比较大，两者之和可能溢出
//            int mid = low + (high - low) / 2;
            int mid = low + ((high - low)>>1); //位运算比除非运算要快，注意加法运算的优先级大于位运算的优先级
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     */
    public static int bsearch(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low)>>1);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            low = mid + 1;
            return bsearch(arr, low, high, value);
        } else {
            high = mid - 1;
            return bsearch(arr, low, high, value);
        }
    }
}
