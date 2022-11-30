package org.example.dsAlgo.binaryTree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class InvertBinaryTreeTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 7, 1, 3, 6, 9}, new int[]{4, 7, 2, 9, 6, 3, 1}),
                Arguments.of(new int[]{2, 1, 3}, new int[]{2, 3, 1}),
                Arguments.of(new int[0], new int[0])
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void test_invertTree(int[] root, int[] output) {
        TreeNode treeNode = createTreeNode(0, root);
        TreeNode expected = createTreeNode(0, output);

        TreeNode actual = new InvertBinaryTree().invertTree(treeNode);

        Assertions.assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    private TreeNode createTreeNode(int i, int[] root) {
        TreeNode treeNode = null;
        if (i < root.length) {
            treeNode = new TreeNode(root[i]);
            treeNode.left = createTreeNode(2 * i + 1, root);
            treeNode.right = createTreeNode(2 * i + 2, root);
        }
        return treeNode;
    }
}
