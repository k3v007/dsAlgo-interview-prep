package org.example.dsAlgo.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidAnagramTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false),
                Arguments.of("s", "s", true),
                Arguments.of("s", "t", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void test_isAnagram(String s, String t, boolean expected) {
        boolean actual = new ValidAnagram().isAnagram(s, t);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}