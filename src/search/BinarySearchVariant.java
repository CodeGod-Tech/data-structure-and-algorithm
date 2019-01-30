package search;

public class BinarySearchVariant {

    public static void main(String[] args) {

        int[] a = {1, 4, 5, 5, 34, 40, 100};
//        int result = bsearchFirst(a, a.length, 5);
//        int result = bsearchLast(a, a.length, 5);
        int result = bsearchFirstBiggerOrEqual(a, a.length, 35);
        System.out.println("result is " + result);

    }


    /**
     * 二分查找循环实现 查找第一个值等于给定值的元素
     *
     */
    public static int bsearchFirst(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) { //注意是<=
//            int mid = (high + low) /2; //如果low和high比较大，两者之和可能溢出
//            int mid = low + (high - low) / 2;
            int mid = low + ((high - low)>>1); //位运算比除非运算要快，注意加法运算的优先级大于位运算的优先级
            if (array[mid] == value) {
                if (mid == 0 || array[mid - 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     */
    public static int bsearchLast(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) { //注意是<=]
            int mid = low + ((high - low)>>1); //位运算比除非运算要快，注意加法运算的优先级大于位运算的优先级
            if (array[mid] == value) {
                if (mid == n-1 || array[mid + 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     */
    public static int bsearchFirstBiggerOrEqual(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) { //注意是<=]
            int mid = low + ((high - low)>>1); //位运算比除非运算要快，注意加法运算的优先级大于位运算的优先级
            if (array[mid] >= value) {
                if (mid == 0|| array[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个小于等于给定值的元素
     *
     */
    public static int bsearchLastSmallerOrEqual(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) { //注意是<=]
            int mid = low + ((high - low)>>1); //位运算比除非运算要快，注意加法运算的优先级大于位运算的优先级
            if (array[mid] <= value) {
                if (mid == n - 1|| array[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


}
