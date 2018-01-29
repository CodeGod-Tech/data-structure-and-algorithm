/**
 * Created by Leon on 2018-01-26.
 */
public class BubbleSort {

    private static void bubbleSort(int[] array) {
        int m = array.length - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - i; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
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