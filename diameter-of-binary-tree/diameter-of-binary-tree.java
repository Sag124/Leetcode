/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int height(TreeNode root) {
        if (root == null) return -1;
        int ht = -1;
        int lh = height(root.left);
        int rh = height(root.right);
        ht = Math.max(ht, Math.max(lh, rh));
        return ht + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int f = height(root.left) + height(root.right) + 2;
        int res = Math.max(Math.max(ld, rd), f);
        return res;
    }
}