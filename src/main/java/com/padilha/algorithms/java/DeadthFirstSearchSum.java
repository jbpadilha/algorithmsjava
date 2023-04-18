package com.padilha.algorithms.java;

public class DeadthFirstSearchSum {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root, maxSum);
        return maxSum;
    }

    private static int maxPathSumHelper(TreeNode node, int maxSum) {
        if (node == null) {
            return 0;
        }
        int leftSum = maxPathSumHelper(node.left, maxSum);
        int rightSum = maxPathSumHelper(node.right, maxSum);
        int nodeSum = Math.max(node.val, Math.max(node.val + leftSum, node.val + rightSum));
        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);
        return nodeSum;
    }


    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        // Find the maximum path sum and print it
        maxPathSum(root);
        // System.out.println("Maximum path sum: " + maxSum);
    }
}
