package org.example.dsAlgo.util;

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
}
