package org.example.dsAlgo.arrays;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CountSubarraySumEqualsKTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[] { 1, 1, 1 }, 2, 2),
                Arguments.of(new int[] { 1, 2, 3 }, 3, 2));
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void test_subarraySum(int[] nums, int k, int expected) {
        int actual = new CountSubarraySumEqualsK().subarraySum(nums, k);

        Assertions.assertThat(expected).isEqualTo(actual);
    }
}
