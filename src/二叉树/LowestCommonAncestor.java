package 二叉树;

/**
 * @description：递归与回溯
 * @date： 2022/5/10 10:46
 * @author：gqlin
 */
public class LowestCommonAncestor {
/*    236. 二叉树的最近公共祖先
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”



    示例 1：


    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    输出：3
    解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
    示例 2：


    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    输出：5
    解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
    示例 3：

    输入：root = [1,2], p = 1, q = 2
    输出：1*/

    //解题步骤：https://www.programmercarl.com/0236.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#java
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return returnRoot(root, p, q);
    }

    public TreeNode returnRoot(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //找到了相等节点
        else if (root.val == q.val || root.val == p.val) {
            return root;
        }

        TreeNode leftRoot = returnRoot(root.left, p, q);
        TreeNode rightRoot = returnRoot(root.right, p, q);
        //左右返回值不为空，说明当前root为目标节点
        if (leftRoot != null && rightRoot != null) {
            return root;
        }
        //左节点不为空，说明目标节点在左子树
        if (leftRoot != null) {
            return leftRoot;
        }
        if (rightRoot != null) {
            return rightRoot;
        }

        return null;
    }
}
