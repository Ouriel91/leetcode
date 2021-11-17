// =========== 2 solutions =============

//Postorder: Left -> Right -> Root

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
    
    private List<Integer> postOrderRec(TreeNode root, List<Integer> list)
    {
        if(null == root)
        {
            return list;
        }
        
        postOrderRec(root.left, list);
        postOrderRec(root.right, list);
        list.add(root.val);
        
        return list;
    }
    
    public List<Integer> postorderTraversal(TreeNode root)     {
        return postOrderRec(root, new ArrayList<Integer>());
    }
}

//iterative
class Solution {
    
    public List<Integer> postorderTraversal(TreeNode root)     {
        
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode traverse = root;
        while(!stack.isEmpty() || null != traverse)
        {
            //post order is reverse of pre order
            if(null != traverse)
            {
                stack.push(traverse);
                list.add(0,traverse.val); //add it in first of list, then add right and left
                traverse = traverse.right;
            }
            else
            {
                TreeNode node = stack.pop();
                traverse = node.left;
            }
        }
        
        return list;
    }
}