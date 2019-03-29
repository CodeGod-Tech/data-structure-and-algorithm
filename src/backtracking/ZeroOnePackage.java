package backtracking;

public class ZeroOnePackage {

    public static int maxW = Integer.MIN_VALUE;


    public static void f(int i, int cw, int[] items, int n, int w) {
        if (i == n || cw == w) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        //不放入背包的情况
        f(i + 1, cw, items, n, w);
        //放入背包的情况
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], items, n, w);
        }
    }

    public static void main(String[] args) {
        int[] items = {2, 5, 8, 10, 3, 5, 6};
        int w = 20;
        f(0, 0, items, items.length, w);
        System.out.println(maxW);
    }
}
