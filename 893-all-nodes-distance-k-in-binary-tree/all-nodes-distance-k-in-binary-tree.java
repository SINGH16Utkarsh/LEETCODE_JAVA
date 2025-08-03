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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       List<Integer> ans = new ArrayList<>();
        dfs(root, target, k, ans);
        return ans;
    }

    public int dfs(TreeNode root, TreeNode target, int k, List<Integer> ans) {
        if (root == null) return -1;

        if (root == target) {
            subTree(root, k, ans);
            return 0;
        }

        int left = dfs(root.left, target, k, ans);
        if (left != -1) {
            if (left + 1 == k) {
                ans.add(root.val);
            } else {
                subTree(root.right, k - left - 2, ans);
            }
            return left + 1;
        }

        int right = dfs(root.right, target, k, ans);
        if (right != -1) {
            if (right + 1 == k) {
                ans.add(root.val);
            } else {
                subTree(root.left, k - right - 2, ans);
            }
            return right + 1;
        }

        return -1;
    }

    public void subTree(TreeNode root, int k, List<Integer> ans) {
        if (root == null || k < 0) return;

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        subTree(root.left, k - 1, ans);
        subTree(root.right, k - 1, ans);
    }
}