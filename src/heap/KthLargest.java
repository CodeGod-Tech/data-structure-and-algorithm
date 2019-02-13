package heap;

import java.util.PriorityQueue;

class KthLargest {

    //PriorityQueue是二叉小顶堆
    private PriorityQueue<Integer> priorityQueue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.priorityQueue = new PriorityQueue<>(k);
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
        } else if (val > priorityQueue.peek()){
            priorityQueue.remove();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }


}
