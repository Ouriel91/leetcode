// =========== 3 solutions =============

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

//recursive solution
class Solution {
    
    public void swap_node(TreeNode node)
    {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    
    public TreeNode invertTree(TreeNode node) {
        
        if(null == node)
        {
            return null;
        }
        
        invertTree(node.left);
        invertTree(node.right);
        
        swap_node(node);
        
        return node;
    }
}

//same recursive solution but shorter
class Solution {
    
    public TreeNode invertTree(TreeNode node) {
        
        if(null == node)
        {
            return null;
        }
        
        TreeNode temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);
        
        return node;
    }
}

//iterative solution - using stack
class Solution {
    
    public TreeNode invertTree(TreeNode root) {
        
        if(null == root)
        {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if(null != node.left)
            {
                stack.push(node.left);
            }
            
            if(null != node.right)
            {
                stack.push(node.right);
            }
        }
        
        return root;
    }
}