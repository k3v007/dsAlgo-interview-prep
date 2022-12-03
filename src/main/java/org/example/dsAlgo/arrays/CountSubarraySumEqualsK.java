package org.example.dsAlgo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/subarray-sum-equals-k/">LeetCode
 *      Question</a>
 */
public class CountSubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int currSum = 0;
        int subarrayCount = 0;
        for (int i = 0; i < nums.length; ++i) {
            currSum += nums[i];
            int diff = currSum - k;
            if (freq.containsKey(diff)) {
                // add all sub-array sum found so far
                subarrayCount += freq.get(diff);
            }
            if (freq.containsKey(currSum)) {
                freq.replace(currSum, freq.get(currSum) + 1);
            } else {
                freq.put(currSum, 1);
            }
        }
        return subarrayCount;
    }
}