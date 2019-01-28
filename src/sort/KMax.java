package sort;


/**
 * O(n) 时间复杂度内求无序数组中的第 K 大元素
 *
 * T(n) = n + n/2 + n/4 + ... + 1 = O(n)
 *
 */
public class KMax {


    //分区函数, 当分区完成之后，分区之间的元素位置已摆好
    public static int partition(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int pivot = a[low];
        while (i < j) {
            while (a[j] >= pivot && i < j) {
                j--;
            }
            while (a[i] <= pivot && i < j) {
                i++;
            }

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

        }
        a[low] = a[i];
        a[i] = pivot;

        return i;
    }


    /**
     *
     * @param a
     * @param low
     * @param high
     * @param position 第K大元素在数组中的位置
     * @return
     */
    public static int kMax(int[] a, int low, int high, int position) {
        String message = String.format("low: %d, high: %d, k: %d", low, high, position);
        System.out.println(message);
        if (low >= high) {
            return a[low];
        }

        int i = partition(a, low, high);
        //当分区的结果与第K大元素在数组中的位置一致时，则已经找到
        System.out.println("partition " + i);
        if (i < position) {
            return kMax(a, i+ 1, high, position);
        } else if (i > position){
            return kMax(a, low, i - 1, position);
        } else {
            return a[i];
        }

    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 7, 8, 9};
        //第K大元素
        int k = 6;
        int value = kMax(array, 0, array.length-1, array.length - k);
        System.out.println("max k value " + value);

    }
}
