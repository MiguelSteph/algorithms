/**
 * Lien du problème : https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * Youtube Video Lien: https://youtu.be/vUZYhd2BgUw
 * Auteur de la solution : Miguel Stephane KAKANAKOU
 * Date: 10-07-2022
 */

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        collectLargestValues(result, root, 0);
        return result;
    }
    
    private void collectLargestValues(List<Integer> result, TreeNode node, int row) {
        if (node == null) return;
        
        if (result.size() > row) {
            int currentMax = result.get(row);
            result.set(row, Math.max(currentMax, node.val));
        } else {
            result.add(node.val);
        }
        collectLargestValues(result, node.left, row+1);
        collectLargestValues(result, node.right, row+1);
    }
}