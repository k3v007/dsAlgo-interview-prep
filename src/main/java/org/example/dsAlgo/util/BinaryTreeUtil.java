package org.example.dsAlgo.util;

import java.util.List;

import org.example.dsAlgo.binaryTree.TreeNode;

public class BinaryTreeUtil {

    public static TreeNode createTreeNode(int i, int[] root) {
        TreeNode treeNode = null;
        if (i < root.length) {
            treeNode = new TreeNode(root[i]);
            treeNode.left = createTreeNode(2 * i + 1, root);
            treeNode.right = createTreeNode(2 * i + 2, root);
        }
        return treeNode;
    }

    public static TreeNode createTreeNode(int i, List<Integer> root) {
        TreeNode treeNode = null;
        if (i < root.size()) {
            if (root.get(i) == null) {
                return null;
            }
            treeNode = new TreeNode(root.get(i));
            treeNode.left = createTreeNode(2 * i + 1, root);
            treeNode.right = createTreeNode(2 * i + 2, root);
        }
        return treeNode;
    }
}
