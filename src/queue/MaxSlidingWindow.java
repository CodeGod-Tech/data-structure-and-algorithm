package queue;

import java.util.concurrent.LinkedBlockingQueue;

//https://blog.csdn.net/jmspan/article/details/51073879
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(k);
        int result[] = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (queue.size() == k) {
                queue.poll();
            }
            queue.add(value);
            while (!queue.isEmpty() && value > queue.peek()) {
                queue.remove();
            }

            if (i >= k - 1) {
                result[i - k + 1] = queue.poll();
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
    }
}
