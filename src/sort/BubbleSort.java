package sort;

/**
 * Created by Leon on 2018-01-26.
 * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求，如果不满足就让它俩互换。一次冒泡
 * 会让至少一个元素移动到它应该在的位置，重复n次，就完成了n个数据的排序工作
 *
 * 时间复杂度O(n^2) 最好情况O(n) 最坏情况O(n^2)
 * 稳定排序,数据相等时不做交换
 * 空间复杂度O(1)
 */
public class BubbleSort {

    private static void bubbleSort(int[] array) {
        int m = array.length - 1;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - i; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    flag = true;
                }
            }
            if (!flag) break;//没有数据交换，直接退出，考虑最好的情况
        }
        for (int value : array) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 100, 50, 22, 15, 6, 1, 1000, 999, 0};
        bubbleSort(a);
    }
}