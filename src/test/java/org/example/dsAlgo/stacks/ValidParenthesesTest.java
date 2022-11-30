package org.example.dsAlgo.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidParenthesesTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("(]", false),
                Arguments.of(")(", false),
                Arguments.of("((()[(]){}){})", false),
                Arguments.of("((()[]){})", true),
                Arguments.of("(])", false),
                Arguments.of("()[]{}", true)
        );
    }

    @ParameterizedTest()
    @MethodSource("provideParameters")
    void test_isValid(String s, boolean expected) {
        boolean actual = new ValidParentheses().isValid(s);

        Assertions.assertEquals(expected, actual);
    }
}
