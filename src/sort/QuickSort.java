package sort;


/**
 * Created by Leon on 2018-01-26.
 *
 * 快排利用分治算法
 *
 * 如果排序数组中下标从p到r之间的一组数据，我们选择p到r之间的任意一个数据作为pivot（分区点），遍历p到r之间的数据，
 * 将小于pivot的放左边，大于pivot放右边，将pivot放中间，然后分治递归，直到区间缩小到1
 *
 * 归并排序是由下而上，先处理子问题，然后再合并；快排是由上而下，先分区，再处理子问题
 *
 * 快排是原地的、不稳定的排序算法
 *
 * 时间复杂度为O(nlogn), 最差情况下时间复杂度为O(n^2)
 *
 *
 *
 */
public class QuickSort {

    private static void quickSort(int[] arr, int left, int right) {
        //递归终止条件
        if (left > right) {
            return;
        }
        //已最左边的元素为pivot
        int temp = arr[left];
        int i = left;//左指针
        int j = right;//右指针
        while (i < j) {
            //从右边开始，非常重要，如果大于pivot，继续往左边走，直到找到小于pivot的元素
            while (arr[j] >=temp && i < j) {
                j--;
            }
            //从左边开始，如果小于pivot，继续往右边走，直到找到大于pivot的元素
            while (arr[i] <=temp && i < j) {
                i++;
            }
            //交换
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //i和j重合时的位置，就是pivot的位置

        //因为右指针先走，所有赋值给最左边的元素
        arr[left] = arr[i];
        arr[i] = temp;//将pivot元素值放在最后的位置

        quickSort(arr, left, i-1);
        quickSort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        //int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int[] array = {5, 3, 1, 7, 8, 9};
        quickSort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
