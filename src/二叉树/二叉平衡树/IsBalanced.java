package 二叉树.二叉平衡树;

import 二叉树.TreeNode;

/**
 * @description：
 * @date： 2022/5/3 11:04
 * @author：gqlin
 */
public class IsBalanced {

    /*    110. 平衡二叉树
        给定一个二叉树，判断它是否是高度平衡的二叉树。

        本题中，一棵高度平衡二叉树定义为：

        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。



        示例 1：
        输入：root = [3,9,20,null,null,15,7]
        输出：true

        示例 2：
        输入：root = [1,2,2,3,3,null,null,4,4]
        输出：false

        示例 3：
        输入：root = []
        输出：true*/
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = balance(root.left);
        int rightHeight = balance(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return false;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ? false : true;

    }

    public int balance(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int leftHeight = balance(cur.left);
        int rightHeight = balance(cur.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        } else if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
