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
     private TreeNode nextRight = null; // acts like the "last visited node" in your image

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right); // reverse postorder: right
        flatten(root.left);  // then left

        // flattening logic
        root.left = null;
        root.right = nextRight;
        nextRight = root;
    }
}