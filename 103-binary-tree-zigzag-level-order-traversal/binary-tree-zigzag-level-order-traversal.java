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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root,0,ans);
        return ans;
    }   
    public static void dfs(TreeNode node,int level, List<List<Integer>> ans ){
        if(node == null)  return;

        if(ans.size()<=level){
            ans.add(new LinkedList<>());
        }

        if(level%2==0){
            ans.get(level).add(node.val); // left to right
        }
        else{
            ans.get(level).add(0,node.val);  //right to left
        }
        //recurse
         dfs(node.left, level+1,ans);
         dfs(node.right, level+1,ans);
    }
}