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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(root.val>key) {
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else { //we have find the node 
        //case 1 if the node is a leaf node 
        if(root.left==null && root.right==null){
          return null;
        }
        //case 2 if the node is one child
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }
        //case 3 if the node is two child
        TreeNode inOrder=inOrderSuccessor(root.right);
        root.val=inOrder.val;
        root.right=deleteNode(root.right, inOrder.val);
        }
   return root;
    }


    private TreeNode inOrderSuccessor(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}