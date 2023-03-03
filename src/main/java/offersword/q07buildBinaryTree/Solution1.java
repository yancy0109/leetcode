package offersword.q07buildBinaryTree;

import java.util.HashMap;

/**
 * @author yancy0109
 */
public class Solution1 {

    private int[] preorder;
    private int[] inorder;
    
    private HashMap<Integer, Integer> inorderTable = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int preLen = preorder.length;
        int inLen = inorder.length;
        for (int i = 0; i < inLen; i++) {
            // 记录中序遍历中每个元素的位置
            inorderTable.put(inorder[i], i);
        }
        return getBinaryTree(0, preLen-1, 0, inLen-1);
    }

    // 根据传入范围获得范围内构成的子树
    public TreeNode getBinaryTree(int pl, int pr, int il, int ir) {
        // 如果当前范围内没有元素
        if (pl > pr) {
            return null;
        }
        // 当前范围根节点的值, 即前序遍历第一个元素
        int root = preorder[pl];
        // 在中序遍历中当前子树Root节点的位置
        Integer rInorderIndex = inorderTable.get(root);
        // 左子树总元素长度
        int lLen = rInorderIndex - il;
        // 右子树宗原诉长度
        int rLen = ir - rInorderIndex;
        // 前序遍历范围[pl+1, pl+1+lLen] 中序遍历范围[il, rInorderIndex-1]
        TreeNode lBinaryTree = getBinaryTree(pl + 1, pl + lLen, il, rInorderIndex-1);
        // 前序遍历范围[pl+1+lLen, ]     中序遍历范围[il, rInorderIndex-1]
        TreeNode rBinaryTree = getBinaryTree(pl + lLen + 1, pr, rInorderIndex + 1, ir);
        TreeNode treeNode = new TreeNode(root);
        treeNode.left = lBinaryTree;
        treeNode.right = rBinaryTree;
        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(new Solution1().buildTree(preorder, inorder));
    }
}
