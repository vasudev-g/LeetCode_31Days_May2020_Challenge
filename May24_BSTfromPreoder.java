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
    public TreeNode bstFromPreorder(int[] p) {
        TreeNode root=new TreeNode(p[0]);
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        int sz=p.length;
        s.push(root); 
        for (int i = 1; i < sz; ++i) { 
            TreeNode tmp = null; 
  
            while (!s.isEmpty() && p[i] > s.peek().val) { 
                tmp = s.pop(); 
            } 
             if (tmp != null) { 
                tmp.right = new TreeNode(p[i]); 
                s.push(tmp.right); 
            } 
             else { 
                tmp = s.peek(); 
                tmp.left = new TreeNode(p[i]); 
                s.push(tmp.left); 
            } 
        } 
  
        return root; 
    }
}