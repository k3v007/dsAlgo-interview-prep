package org.example.dsAlgo.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ThreeNumberSumTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[] { -1, 0, 1, 2, -1, -4 },
                        Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, -1))));
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void test_threeSum(int[] nums, List<List<Integer>> expected) {
        List<List<Integer>> actual = new ThreeNumberSum().threeSum(nums);
        expected.stream()
                .map(s -> s.stream().sorted().collect(Collectors.toList()))
                .collect(Collectors.toList());

        Assertions.assertThat(actual).containsAnyElementsOf(expected);
    }
}
