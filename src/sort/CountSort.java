package sort;

/**
 * 计数排序是桶排序的特殊一种
 *
 * 计算排序只能用在数据范围不大的场景中，如果数据范围k要比排序的数据n大很多，就适合使用计算排序了
 *
 * 时间复杂度O(n)
 */
public class CountSort {

    public static void bucketSort(int[] array, int max) {
        int[] a = new int[max+1];
        for (int value : array) {
            a[value]++;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i]; j++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 4, 3, 2 ,5 };
        bucketSort(array, 6);
    }
}