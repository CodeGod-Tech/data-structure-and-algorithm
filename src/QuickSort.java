import java.util.PrimitiveIterator;

/**
 * Created by Leon on 2018-01-26.
 */
public class QuickSort {

    private static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int temp = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            //从右边开始，非常重要
            while (arr[j] >=temp && i < j) {
                j--;
            }
            while (arr[i] <=temp && i < j) {
                i++;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort(arr, left, i-1);
        quickSort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
