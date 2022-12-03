package org.example.dsAlgo.arrays;

import java.util.Arrays;

/**
 * @see <a href=
 *      "https://wentao-shao.gitbook.io/leetcode/two-pointers/1099.two-sum-less-than-k">1099.Two-Sum-Less-Than-K</a>
 */
public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int maxSum = -1;
        while (i < j) {
            int currSum = nums[i] + nums[j];
            if (currSum >= k) {
                --j;
            } else {
                maxSum = Math.max(maxSum, currSum);
                ++i;
            }
        }
        return maxSum;
    }
}
