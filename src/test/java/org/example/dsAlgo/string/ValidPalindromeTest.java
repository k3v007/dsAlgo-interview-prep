package org.example.dsAlgo.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidPalindromeTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true),
                Arguments.of("0P", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void test_isPalindrome(String s, boolean expected) {
        boolean actual = new ValidPalindrome().isPalindrome(s);

        Assertions.assertEquals(expected, actual);
    }
}
