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
    public boolean isBalanced(TreeNode root) {
       
       return height(root) !=-1;
      
        
    }
    public static int height(TreeNode root){
       if(root == null){
            return 1;
        }
        int lh = height(root.left);
        if(lh == -1){
            return -1;
        }
        int rh = height(root.right);
        if(rh == -1){
            return -1;
        }
        if(Math.abs(lh-rh)>1){
            return -1;
        }
        return Math.max(lh,rh)+1;
    }
}