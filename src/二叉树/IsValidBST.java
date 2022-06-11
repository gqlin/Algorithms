package 二叉树;


/**
 * @description：中序遍历二叉搜索树，就可以得到一个从小到大的序列
 * @date： 2022/5/8 21:06
 * @author：gqlin
 */
public class IsValidBST {

/*
    98. 验证二叉搜索树
    给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

    有效 二叉搜索树定义如下：

    节点的左子树只包含 小于 当前节点的数。
    节点的右子树只包含 大于 当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。


    示例 1：
    输入：root = [2,1,3]
    输出：true

    示例 2：
    输入：root = [5,1,4,null,null,3,6]
    输出：false
    解释：根节点的值是 5 ，但是右子节点的值是 4 。*/


    //解题步骤：https://www.programmercarl.com/0098.%E9%AA%8C%E8%AF%81%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html

    TreeNode pre = new TreeNode();

    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root);
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftRes = isValidBST1(root.left);
        if (leftRes == false) {
            return false;
        }

        if (root.val <= pre.val) {
            return false;
        }
        pre = root;
        boolean rightRes = isValidBST1(root.right);
        return rightRes;
    }

}
