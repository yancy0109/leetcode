package dailyCode.q2331computeBooleanBinaryTree;

/**
 * @author yancy0109
 */
public class Solution1 {

    // 递归遍历二叉树，中序遍历
    public boolean evaluateTree(TreeNode root) {
        // 如果为单点数，直接返回
        if (root.left == null || root.right == null) {
            return root.val == 1;
        }
        // 如果有子节点
        if (root.val == 2) {
            // 左字数结果 || 右子树结果
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        // 左字数结果 && 右子树结果
        return evaluateTree(root.left) && evaluateTree(root.right);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        TreeNode treeNode = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, new TreeNode(0, null, null), new TreeNode(1, null, null)));
        System.out.println(solution1.evaluateTree(treeNode));
    }
}
