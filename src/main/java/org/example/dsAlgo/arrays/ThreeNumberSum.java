package org.example.dsAlgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeNumberSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Set<List<Integer>> solutions = new HashSet<>();
        for (int i = 0; i <= nums.length - 3; ++i) {
            Set<Integer> lookup = new HashSet<>();
            for (int j = i + 1; j < nums.length; ++j) {
                if (j == i + 1) {
                    lookup.add(nums[j]);
                } else {
                    int diff = 0 - nums[i] - nums[j];
                    if (lookup.contains(diff)) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], diff);
                        Collections.sort(triplet);
                        solutions.add(triplet);
                    }
                }
                lookup.add(nums[j]);
            }
        }
        return new ArrayList<>(solutions);
    }
}
