package org.example.dsAlgo.arrays;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TwoSumLessThanKTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[] { 34, 23, 1, 24, 75, 33, 54, 8 }, 60, 58),
                Arguments.of(new int[] { 10, 20, 30 }, 15, -1));
    }

    @ParameterizedTest(name = "Input: nums={0}, target={1} :: Output: {2}")
    @MethodSource("provideParameters")
    void test_twoSumLessThanK(int[] nums, int k, int expected) {
        int actual = new TwoSumLessThanK().twoSumLessThanK(nums, k);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
