package org.example.dsAlgo.binaryTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.example.dsAlgo.util.BinaryTreeUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HeightBalancedBTTest {

    public static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4), false),
                Arguments.of(Arrays.asList(3, 9, 20, null, null, 15, 7), true),
                Arguments.of(Arrays.asList(1, 2, 2, 3, null, null, 3, 4, null, null, 4), false),
                Arguments.of(Collections.emptyList(), true));
    }

    @ParameterizedTest(name = "Input: root={0} :: Output: {1}")
    @MethodSource("parametersProvider")
    void test_isBalanced(List<Integer> tree, boolean expected) {
        TreeNode treeNode = BinaryTreeUtil.createTreeNode(0, tree);

        boolean actual = new HeightBalancedBT().isBalanced(treeNode);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "Input: root={0} :: Output: {1}")
    @MethodSource("parametersProvider")
    void test_isBalanced2(List<Integer> tree, boolean expected) {
        TreeNode treeNode = BinaryTreeUtil.createTreeNode(0, tree);

        boolean actual = new HeightBalancedBT().isBalanced2(treeNode);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
