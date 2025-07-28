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
    private int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        FindmaxPath(root);
        return maxsum;
    }
      private int FindmaxPath(TreeNode node ) {             
        if(node==null){
            return 0;
        }
        int leftmax=Math.max(FindmaxPath(node.left),0);
        int rightmax=Math.max(FindmaxPath(node.right),0);
        int currmax= leftmax+rightmax+node.val;

       maxsum=Math.max(maxsum,currmax);
        return node.val+Math.max(leftmax,rightmax);
    }
}