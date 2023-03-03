package offersword.q19inorderSuccessor_acwing;

/**二叉树的下一个节点
 * @author yancy0109
 */
public class Solution1 {
    public TreeNode inorderSuccessor(TreeNode p) {
        // 如果当前节点有右节点
        if (p.right != null) {
            p = p.right;
            // 返回右节点的最左边节点
            while (p.left != null) p = p.left;
            return p;
        }
        // 如果为当前节点为父节点的右子树
        //      1
        //   2     3
        // 4   5
        //   6   7
        //  8     9
        // 如 节点9 我们则要找输出2节点的父节点
        // 为右叶子节点的情况 向上找到一个节点 此节点为它父节点的左节点
        while (p.father != null && p.father.right == p) p = p.father;
        // 此时应该下一节点为左子树的父节点
        return p.father;
    }


}

