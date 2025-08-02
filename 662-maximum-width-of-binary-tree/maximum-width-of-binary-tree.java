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
    static class Pair {
    TreeNode fst;
    int sec;

    public Pair(TreeNode fst, int sec) {
        this.fst = fst;
        this.sec = sec;
    }
}

public int widthOfBinaryTree(TreeNode root) {
    int max = 0;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, 0));

    while (!q.isEmpty()) {
        int left = q.peek().sec;
        int right = ((LinkedList<Pair>) q).getLast().sec;
        max = Math.max(max, right - left + 1);

        int n = q.size();
        while (n-- > 0) {
            Pair currPair = q.poll();
            TreeNode curr = currPair.fst;
            int idx = currPair.sec;

            if (curr.left != null) {
                q.add(new Pair(curr.left, (2 * idx) + 1));
            }
            if (curr.right != null) {
                q.add(new Pair(curr.right, (2 * idx) + 2));
            }
        }
    }

    return max;
}
}