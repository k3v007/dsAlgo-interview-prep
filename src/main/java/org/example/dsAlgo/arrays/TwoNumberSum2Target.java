package org.example.dsAlgo.arrays;

public class TwoNumberSum2Target {

    // Two pointer approach - O(N)
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] { i + 1, j + 1 }; // 1-indexed
            }
            if (sum > target) {
                --j;
            } else {
                ++i;
            }
        }
        return new int[0];
    }
}
