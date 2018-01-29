/**
 * Created by Leon on 2018-01-26.
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j-1];
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
