package map;

import java.util.HashMap;

/**
 * 1. 暴力破解 O(n^2)
 * 2. map
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp) && i != hashMap.get(temp)) {
                result[0] = i;
                result[1] = hashMap.get(temp);
                return result;
            }
        }
        return null;
    }
}
