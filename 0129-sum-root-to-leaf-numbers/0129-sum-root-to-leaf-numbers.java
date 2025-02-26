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
    int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        makeNumber(root, 0);
        return ans;
    }

    private void makeNumber(TreeNode node, int number) {
        if (node == null) {
            return;
        }
        number = number * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += number;
            number = number / 10;
            return;
        }
        makeNumber(node.left, number);
        makeNumber(node.right, number);
    }
}