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
    int tilt = 0;
    public int findTilt(TreeNode root) {
        tilt = 0;
        valueSum(root);
        return tilt;
    }
    
    public int valueSum(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int left_sum = valueSum(root.left);
        int right_sum = valueSum(root.right);
        
        int local_tilt = Math.abs(left_sum - right_sum);
        tilt += local_tilt;
        
        int total_sum = left_sum + right_sum + root.val;
        return total_sum;
    }
}