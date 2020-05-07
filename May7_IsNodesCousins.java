/* In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100. */

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
    public boolean isCousins(TreeNode root, int x, int y) {
        
                    
        TreeNode tx = node(root,x);
        TreeNode ty = node(root,y);
                  
        if((level(root,tx,1) == level(root,ty,1) && (!isSameParent(root,tx,ty))))
           return true;
        
           return false;
        
    }
     boolean isSameParent(TreeNode node, TreeNode x, TreeNode y) 
    { 
        
        if (node == null) 
            return false; 
  
        return ((node.left == x && node.right == y) || 
                (node.left == y && node.right == x) || 
                isSameParent(node.left, x, y) || 
                isSameParent(node.right, x, y)); 
    } 
   int level(TreeNode node, TreeNode key, int lev) 
    { 
       
        if (node == null) 
            return 0; 
  
        if (node == key) 
            return lev; 
  
        int l = level(node.left, key, lev + 1); 
        
  
        int r=level(node.right, key, lev + 1); 
        if (l != 0) 
            return l; 
        return r;
    } 
    TreeNode node(TreeNode root, int x)
    {
        if(root == null)
            return null;
        if(root.val == x)
        {
            return root;
        }
        
        TreeNode l = node(root.left,x);
        TreeNode r = node(root.right,x);
        if(l!=null)
            return l;
        return r;
    }
}