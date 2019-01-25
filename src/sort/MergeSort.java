package sort;

/**
 * 归并算法
 *
 * 时间复杂度O(nlogn)
 * 稳定算法
 *
 * 时间复杂度推导  T(a) = T(b) + T(c) + K; K等于将子问题b和c的结果合并成问题a结果消耗的时间
 *
 * T(n) = T(n/2) + T(n/2) + K = 2*T(n/2) + n = 2^k * T(n/(2^k)) + n * k;
 * 当n/(2^k)=1时，k=logn, T(n) = n * T(1) + n * logn
 * T(n) = O(n*logn);
 *
 * 空间复杂度 按照时间复杂度来分析，空间复杂度也是O(nlogn)，但是由于函数调用之后会释放掉内存，所有空间复杂度为O(n)
 *
 * 归并排序不是原地排序
 *
 *
 */
public class MergeSort {


    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i <= mid && j<= high){
            if(a[i] <= a[j]){ //是否是稳定算法的关键
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x = 0; x < temp.length; x++){
            a[x+low] = temp[x];
        }
    }

    public static int[] sort(int[] a,int low, int high){
        int mid = (low + high)/2;
        if(low < high){
            sort(a, low, mid);
            sort(a,mid+1, high);
            //左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 2};
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
