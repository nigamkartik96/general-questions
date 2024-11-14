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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                count ++;
                if (count == k) return curr.val;
                curr = curr.right;
            } else {
                TreeNode currLeft = curr.left;
                while (currLeft.right != null && currLeft.right != curr) {
                    currLeft = currLeft.right;
                }

                if (currLeft.right == curr) {
                    currLeft.right = null;
                    count++;
                    if (count == k) {return curr.val;};
                    curr = curr.right;
                } else {
                    currLeft.right = curr;
                    curr = curr.left;
                }
            }
        }

        return -1;
    }
}