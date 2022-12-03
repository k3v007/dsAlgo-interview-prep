package org.example.dsAlgo.arrays;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TwoNumberSum2TargetTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 }),
                Arguments.of(new int[] { 3, 2, 4 }, 6, new int[] { 1, 2 }),
                Arguments.of(new int[] { 3, 3 }, 6, new int[] { 0, 1 }));
    }

    @ParameterizedTest(name = "Input: nums={0}, target={1} :: Output: {2}")
    @MethodSource("provideParameters")
    void test_twoSum(int[] nums, int target, int[] expected) {

        int[] actual = new TwoNumberSumTarget().twoSum(nums, target);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
