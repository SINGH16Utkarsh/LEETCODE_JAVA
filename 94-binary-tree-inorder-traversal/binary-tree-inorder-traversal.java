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
    public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // print curr
                result.add(curr.val);
                curr = curr.right;
            } else {
                // find Inorder Predecessor (IP)
                TreeNode IP = curr.left;
                while (IP.right != null && IP.right != curr) {
                    IP = IP.right;
                }

                if (IP.right == null) {
                    // create thread
                    IP.right = curr;
                    curr = curr.left;
                } else {
                    // delete thread
                    IP.right = null;

                    // print curr
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return result;
    }
}