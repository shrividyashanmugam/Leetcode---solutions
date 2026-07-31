import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) return;
        
        traverse(node.left, result);  // 1. Visit Left
        traverse(node.right, result); // 2. Visit Right
        result.add(node.val);         // 3. Visit Root
    }
}