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
   private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        computeHeight(root);
        return maxDiameter;
    }

    // Helper method: returns height, updates diameter
    private int computeHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = computeHeight(node.left);
        int rightHeight = computeHeight(node.right);

        // Update diameter at this node
        int diameterAtNode = leftHeight + rightHeight;
        maxDiameter = Math.max(maxDiameter, diameterAtNode);

        // Return height to parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}