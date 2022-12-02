package org.example.dsAlgo.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBT {

    /**
     * By using rootToNode paths for both the node p and q
     * Finding the nearest common node in the above two rootToNode paths array
     * (traversing from root to node side)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        boolean pathExistsP = findPath(root, p.val, pathP);
        boolean pathExistsQ = findPath(root, q.val, pathQ);

        if (!pathExistsP || !pathExistsQ) {
            return null;
        }

        // Here, root node is for sure the ancestor of p and q
        TreeNode lca = pathP.get(0);
        int i = 1;
        int j = 1;
        while (i < pathP.size() && j < pathQ.size()) {
            if (pathP.get(i).val == pathQ.get(j).val) {
                lca = pathP.get(i);
            }
            ++i;
            ++j;
        }
        return lca;
    }

    private boolean findPath(TreeNode root, int node, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(new TreeNode(root.val));
        if (root.val == node) {
            return true;
        }

        if (findPath(root.left, node, path) || findPath(root.right, node, path)) {
            return true;
        }

        // Current root node is doesn't lie in the current path as the node
        // doesn't lie in any of the left or right subtrees
        path.remove(path.size() - 1);
        return false;
    }
}
