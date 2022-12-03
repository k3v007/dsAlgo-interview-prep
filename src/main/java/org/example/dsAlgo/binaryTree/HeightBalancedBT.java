package org.example.dsAlgo.binaryTree;

import javafx.util.Pair;

public class HeightBalancedBT {

    // Height-balanced tree means for all the nodes, height of left and right
    // subtree
    // should not be greater than 1 and also left and right subtree should also be
    // height-balanced
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        if (Math.abs(rightHeight - leftHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    // Calculate height and decide whether the tree is balanced or not
    // simultaneously
    // If at any node the tree is not balance then the same should be reflected back
    // for the whole tree
    public boolean isBalanced2(TreeNode root) {
        Pair<Integer, Boolean> balancedHeight = findBalancedHeight(root);
        return balancedHeight.getValue();
    }

    private Pair<Integer, Boolean> findBalancedHeight(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, true);
        }

        Pair<Integer, Boolean> left = findBalancedHeight(root.left);
        Pair<Integer, Boolean> right = findBalancedHeight(root.right);

        int height = Math.max(left.getKey(), right.getKey()) + 1;
        // both subtrees should be balanced and current node should also be balanced
        boolean isHeightBalanced = left.getValue() && right.getValue() &&
                (Math.abs(left.getKey().intValue() - right.getKey().intValue()) <= 1);

        return new Pair<>(height, isHeightBalanced);
    }
}
