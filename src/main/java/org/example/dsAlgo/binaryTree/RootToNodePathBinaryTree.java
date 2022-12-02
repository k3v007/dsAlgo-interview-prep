package org.example.dsAlgo.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePathBinaryTree {

    public int[] findRootToNodePath(TreeNode root, int node) {
        List<Integer> rootToNodePath = new ArrayList<>();
        boolean nodeExists = findNode(root, node, rootToNodePath);
        if (!nodeExists) {
            return new int[0];
        }
        // Remember type casting of primitive to Java objects and vice-versa
        return rootToNodePath.stream()
                .mapToInt(Integer::intValue).toArray();

    }

    // Assumption that all elements are unique
    public boolean findNode(TreeNode root, int node, List<Integer> path) {
        if (root == null) {
            return false;
        }

        // Store current path
        path.add(root.val);

        if (root.val == node) {
            return true;
        }

        if (findNode(root.left, node, path) || findNode(root.right, node, path)) {
            return true;
        }

        // If node doesn't exist in left or right subtree then
        // the current root node doesn't contains the target
        path.remove(path.size() - 1);
        return false;
    }
}
