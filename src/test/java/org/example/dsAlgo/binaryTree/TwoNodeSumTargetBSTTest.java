package org.example.dsAlgo.binaryTree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.example.dsAlgo.util.BinaryTreeUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TwoNodeSumTargetBSTTest {

    public static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(5, 3, 6, 2, 4, null, 7), 9, true));
    }

    @ParameterizedTest(name = "Input: root={0}, target={1} :: Output: {2}")
    @MethodSource("parametersProvider")
    void test_findTarget(List<Integer> root, int target, boolean expected) {
        TreeNode treeNode = BinaryTreeUtil.createTreeNode(0, root);
        boolean actual = new TwoNodeSumTargetBST().findTarget(treeNode, target);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "Input: root={0}, target={1} :: Output: {2}")
    @MethodSource("parametersProvider")
    void test_findTarget2(List<Integer> root, int target, boolean expected) {
        TreeNode treeNode = BinaryTreeUtil.createTreeNode(0, root);
        boolean actual = new TwoNodeSumTargetBST().findTarget2(treeNode, target);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
