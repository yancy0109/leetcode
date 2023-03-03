package offersword.q7buildBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 迭代法
 * 正序前序遍历 逆序中序遍历
 * 不断找到前序遍历顺序下的左子树最终点，此时逆序中序遍历，
 * 即可找到前序遍历下发现的一个右节点的父节点
 * @author yancy0109
 */
public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        // 树根节点
        TreeNode root = new TreeNode(preorder[0]);
        // 记录还妹分配右子树的节点
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        // 指向中序遍历
        int inorderIndex = 0;
        // 遍历前序遍历 分别判断为左子树/右子树 不断遍历 将未记录右子树的节点推入栈中
        for (int i = 1; i < preorder.length; i++) {
            int preorderNode = preorder[i];
            // 取出stack中首位节点
            TreeNode node = stack.peek();
            // 如果不相等 说明当前preorderNode一定为node的左子树
            // 因为如果当前节点为右子树 那么中序遍历的指针一定指向了中间节点
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderNode);
                // 将未设定右子树的左子树也记录到Stack中
                stack.push(node.left);
                continue;
            }
            // 如果为右子树 inorderIndex应该指向了与Node相同的节点
            // 则当前preorderNode为Stack中某一个元素的右子树
            // 这个右节点可能未栈内任何一个元素的右节点 但是这个右子树节点在中序遍历中一定与父母节点紧挨
            // 不断POP栈内元素 如果Index指向与栈顶不相同 则它之前的元素 即为当前preorderNode的父节点
            while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                // 记录栈顶节点
                node = stack.pop();
                inorderIndex++;
            }
            // 设置右子树
            node.right = new TreeNode(preorderNode);
            // 将右子树继续放入Stack中
            stack.push(node.right);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(new Solution2().buildTree(preorder, inorder));
    }
}
