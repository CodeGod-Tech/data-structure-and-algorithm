package backtracking;

public class EightQueen {

    public static int total = 0;
    public static final int n = 8;
    public static int[] c = new int[n];

    public static void queen(int row) {
        if (row == n) {
            total++;
        } else {
            //遍历每一列
            for (int col = 0; col != n; col++) {
                c[row] = col;//尝试放置皇后
                if (isOK(row)) {
                    queen(row + 1);
                }
            }
        }
    }

    //判断在当前行的放置是否OK
    public static boolean isOK(int row) {
        //从上到下每一行检查
        for (int j = 0; j != row; j++) {
            //检查同一列或对角线上是否有
            if (c[j] == c[row] || (row - j == c[j] - c[row]) || (row - j == c[row] - c[j])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        queen(0);
        //92种解法
        System.out.println(total);
    }
}
