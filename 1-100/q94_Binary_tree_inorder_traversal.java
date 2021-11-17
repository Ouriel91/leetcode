// =========== 2 solutions =============

//Inorder: Left -> Root -> Right

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

//recursive
class Solution {
    
    private List<Integer> inorderRec(TreeNode root, List<Integer> list)
    {
        if(null == root)
        {
            return list;
        }
        
        inorderRec(root.left, list);
        list.add(root.val);
        inorderRec(root.right, list);
        
        return list;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderRec(root, new ArrayList<Integer>());
    }
}

//iterative
class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode traverse = root;
        while(!stack.isEmpty() || null != traverse)
        {
            if(null != traverse)
            {
                stack.push(traverse);
                traverse = traverse.left;
            }
            else
            {
                TreeNode node = stack.pop();
                list.add(node.val); //add left first then root , move right and add right
                traverse = node.right;
            }
        }
        
        return list;
    }
}
