package heap;


import java.util.PriorityQueue;

//https://blog.csdn.net/jmspan/article/details/51073879
//https://leetcode.com/problems/sliding-window-maximum/
public class MaxSlidingWindow {

    //大顶堆实现
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0) return nums;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.add(-nums[i]);
        }
        int result[] = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k; i++) {
            result[i] = -priorityQueue.peek();
            priorityQueue.remove(-nums[i]);
            priorityQueue.add(-nums[k + i]);
        }
        result[nums.length - k] = -priorityQueue.peek();
        return result;
    }

}
