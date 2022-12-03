package org.example.dsAlgo.binaryTree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.example.dsAlgo.util.BinaryTreeUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MaximumDepthBTTest {

    public static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 9, 20, null, null, 15, 7), 3),
                Arguments.of(Arrays.asList(1, null, 2), 2));
    }

    @ParameterizedTest(name = "Input: root={0} :: Output: {1}")
    @MethodSource("parametersProvider")
    void test_maxDepth(List<Integer> tree, int expected) {
        TreeNode treeNode = BinaryTreeUtil.createTreeNode(0, tree);

        int actual = new MaximumDepthBT().maxDepth(treeNode);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
