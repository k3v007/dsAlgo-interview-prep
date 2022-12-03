package org.example.dsAlgo.binaryTree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.example.dsAlgo.util.BinaryTreeUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LowestCommonAncestorBTTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5), 2, 8, 6),
                Arguments.of(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5), 2, 4, 2),
                Arguments.of(Arrays.asList(2, 1), 1, 2, 2));
    }

    @ParameterizedTest(name = "Input: tree={0}, p={1}, q={2} :: Output: {3}")
    @MethodSource("provideParameters")
    void test_lowestCommonAncestor(List<Integer> tree, int p, int q, int expected) {
        TreeNode treeNode = BinaryTreeUtil.createTreeNode(0, tree);
        TreeNode actual = new LowestCommonAncestorBT().lowestCommonAncestor(treeNode, new TreeNode(p), new TreeNode(q));

        Assertions.assertThat(actual.val).isEqualTo(expected);
    }

    @ParameterizedTest(name = "Input: tree={0}, p={1}, q={2} :: Output: {3}")
    @MethodSource("provideParameters")
    void test_findLCA(List<Integer> tree, int p, int q, int expected) {
        TreeNode treeNode = BinaryTreeUtil.createTreeNode(0, tree);
        TreeNode actual = new LowestCommonAncestorBT().findLCA(treeNode, new TreeNode(p), new TreeNode(q));

        Assertions.assertThat(actual.val).isEqualTo(expected);
    }

}
