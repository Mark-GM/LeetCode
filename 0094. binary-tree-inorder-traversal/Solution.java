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
        // if there are no nodes in tree return an empty list
        if (root == null) {
            return Collections.emptyList();
        }
        
        List<Integer> numbers = new ArrayList<>();
        // Left-Parent-Right order
        Stack<TreeNode> inOrderNodes = new Stack<>();
        // while there are nodes to check
        while (root != null || !inOrderNodes.isEmpty()) {
            // keep stacking left child items on top of roots
            // if a right-child node is null then don't try to push anything
            // just pop another node AND add its value to list
            while (root != null) {
                inOrderNodes.push(root);
                root = root.left;
            }
            // pop out the last inserted item if any was insert
            root = inOrderNodes.pop();
            // add current node value
            numbers.add(root.val);
            // go to the right child of current node
            root = root.right;
        }
        
        return numbers;
    }
}