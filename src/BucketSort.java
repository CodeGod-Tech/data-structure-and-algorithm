import java.util.PrimitiveIterator;

public class BucketSort {

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