package sort;

/**
 * Created by Leon on 2018-01-26.
 * 将数据分为两个区间，已排序区间和未排序区间，插入算法的核心思想就是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，
 * 并保证已排序区间的数据一直有序，重复这个过程，直到未排序区间中的元素为空，算法结束。
 *
 * 空间复杂度 O(1)
 * 稳定排序
 * 时间复杂度 最好O(n) 最差O(n^2)
 *
 * 插入排序和冒泡排序虽然时间复杂度O(n^2), 但插入排序效率更高
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j-1]; //移动次数等于逆序度
                j--;
            }
            array[j] = temp;
        }
    }


    public static void main(String[] args) {
        int[] a = {3, 1, 4, 2};
        insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
