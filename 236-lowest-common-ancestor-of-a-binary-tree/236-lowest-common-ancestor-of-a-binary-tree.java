/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public boolean find(TreeNode root, TreeNode data, List<TreeNode> path) {
        if (root == null) return false;
        
        if (root == data) {
            path.add(root);
            return true;
        }
        
        boolean fil = find(root.left, data, path);
        if (fil) {
            path.add(root);
            return true;
        }
        
        boolean fir = find(root.right, data, path);
        if (fir) {
            path.add(root);
            return true;
        }
        
        return false;
    }
    
    public List<TreeNode> nodeToRootPath(TreeNode root, TreeNode data) {
        List<TreeNode> path = new ArrayList<>();
        find(root, data, path);
        return path;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = nodeToRootPath(root, p);
        List<TreeNode> path_q = nodeToRootPath(root, q);
        
        int i = path_p.size() - 1, j = path_q.size() - 1;
        while (i >= 0 && j >=0 && path_p.get(i) == path_q.get(j)) {
            i--;
            j--;
        }
        
        i++;
        j++;
        
        return path_p.get(i);
    }
}