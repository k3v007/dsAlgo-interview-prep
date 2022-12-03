package org.example.dsAlgo.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

/**
 * @see <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/"a>653. Two Sum IV - Input is a BST</a>
 * @See https://leetcode.com/discuss/study-guide/2044134/javarecursion-when-using-primitive-data-types-and-objects-beginners-guide
 */
public class TwoNodeSumTargetBST {

    private boolean isFound = false;

    // O(Nlog(N)) solution
    public boolean findTarget(TreeNode root, int k) {
        TreeNode temp = root;
        findTargetUsingInorder(temp, root, k);
        return isFound;
    }

    private void findTargetUsingInorder(TreeNode temp, TreeNode root, int target) {
        if (temp == null) {
            return;
        }
        
        findTargetUsingInorder(temp.left, root, target);

        int diff = target - temp.val;
        if (diff > temp.val) {
            TreeNode t = findNode(root, target - temp.val);
            if (t != null) {
                isFound = true;
            }
        }

        findTargetUsingInorder(temp.right, root, target);
    }

    private TreeNode findNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        if (root.val == k) {
            return root;
        }

        if (root.val > k) {
            return findNode(root.left, k);
        }

        return findNode(root.right, k);
    }

    // O(N) solution though it takes O(N) auxilary space
    public boolean findTarget2(TreeNode root, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        preOrderTraversal(root, k, freq, pairs);
        return !pairs.isEmpty();
    }

    public void preOrderTraversal(TreeNode root, int k, Map<Integer, Integer> freq, List<Pair<Integer, Integer>> pairs) {
        if (root == null) {
            return;
        }
        int diff = k - root.val;
        if (freq.containsKey(diff)) {
            pairs.add(new Pair<Integer,Integer>(root.val, diff));
        }
        freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);

        preOrderTraversal(root.left, k, freq, pairs);
        preOrderTraversal(root.right, k, freq, pairs);
    }
}
