package org.example.dsAlgo.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BinarySearchTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1),
                Arguments.of(new int[]{-1, 0}, 2, -1),
                Arguments.of(new int[]{-1, 0}, 0, 1),
                Arguments.of(new int[]{-1, 0}, -1, 0),
                Arguments.of(new int[]{-1}, -1, 0),
                Arguments.of(new int[]{-1}, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void test_search(int[] nums, int target, int expected) {
        int actual = new BinarySearch().search(nums, target);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}