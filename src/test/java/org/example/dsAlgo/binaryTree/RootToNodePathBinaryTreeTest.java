package org.example.dsAlgo.binaryTree;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.example.dsAlgo.util.BinaryTreeUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RootToNodePathBinaryTreeTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 5, new int[]{1, 2, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, new int[0]),
                Arguments.of(new int[0], 8, new int[0]),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1}, 2, new int[0]));

    }

    @ParameterizedTest(name = "Input: tree={0}, node={1} :: Output: {2}")
    @MethodSource("provideParameters")
    void test_findRootToNodePath(int[] tree, int node, int[] expected) {
        TreeNode root = BinaryTreeUtil.createTreeNode(0, tree);
        int[] actual = new RootToNodePathBinaryTree().findRootToNodePath(root, node);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
