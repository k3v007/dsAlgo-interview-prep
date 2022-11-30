package org.example.dsAlgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSumTarget {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                lookup.put(nums[0], 0);
            } else {
                int diff = target - nums[i];
                if (lookup.containsKey(diff)) {
                    return new int[]{lookup.get(diff), i};
                }
                lookup.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
