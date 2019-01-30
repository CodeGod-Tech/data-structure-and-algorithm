package sort;

/**
 * 选择排序
 *
 * 区分已排序区间和未排序区间，每次从未排序区间中选一个最小值，放到已排序区的末尾（交换实现）
 *
 * 空间复杂度 O(1)
 * 时间复杂度 O(n^2)
 * 不稳定 例如 5 8 5 2 9
 */
public class SelectionSort {


    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            //在未排序区间中寻找最小值
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            //交换
            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 100, 50, 22, 15, 6, 1, 1000, 999, 0};
        selectionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
