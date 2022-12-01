package org.example.dsAlgo.graph;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FloodFillTest {

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2,
                        new int[][] { { 2, 2, 2 }, { 2, 2, 0 }, { 2, 0, 1 } }),
                Arguments.of(new int[][] { { 0, 0, 0 }, { 0, 1, 0 } }, 1, 1, 2,
                        new int[][] { { 0, 0, 0 }, { 0, 2, 0 } }),
                Arguments.of(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 0, 0, 0,
                        new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }));
    }

    @ParameterizedTest(name = "Inputs: image={0}, sr={1}, sc={2}, color={3} :: Output: {4}")
    @MethodSource("parametersProvider")
    void test_floodFill(int[][] image, int sr, int sc, int color, int[][] expected) {
        int[][] actual = new FloodFill().floodFill(image, sr, sc, color);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
