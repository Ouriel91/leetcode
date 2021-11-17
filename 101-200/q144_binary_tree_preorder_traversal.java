// =========== 2 solutions =============

//Preorder: Root -> Left -> Right 

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
    
    private List<Integer>preorderRec(TreeNode root, List<Integer> list)
    {
        if(null == root)
        {
            return list;
        }
        
        list.add(root.val);
        preorderRec(root.left, list);
        preorderRec(root.right, list);
        
        return list;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderRec(root, new ArrayList<>());       
    }
}

//iterative
class Solution {
    
    public List<Integer>preorderTraversal(TreeNode root)     {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode traverse = root;
        while(!stack.isEmpty() || null != traverse)
        {
            //preorder is reverse of postorder
            if(null != traverse)
            {
                stack.push(traverse);
                list.add(traverse.val); // add root in the end then left and then right
                traverse = traverse.left;
            }
            else
            {
                TreeNode node = stack.pop();
                traverse = node.right;
            }
        }
                
        return list;
    }
}
