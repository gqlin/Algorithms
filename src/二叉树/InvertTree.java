package 二叉树;

/**
 * @description：
 * @date： 2022/4/29 20:43
 * @author：gqlin
 */
public class InvertTree {

/*226. 翻转二叉树 https://leetcode-cn.com/problems/invert-binary-tree/

    给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。*/

/*    解题思路：
    我们之前介绍的都是各种方式遍历二叉树，这次要翻转了，感觉还是有点懵逼。

    这得怎么翻转呢？

    可以发现想要翻转它，其实就把每一个节点的左右孩子交换一下就可以了。

    关键在于遍历顺序，前中后序应该选哪一种遍历顺序？ （一些同学这道题都过了，但是不知道自己用的是什么顺序）

    遍历的过程中去翻转每一个节点的左右孩子就可以达到整体翻转的效果。

    注意只要把每一个节点的左右孩子翻转一下，就可以达到整体翻转的效果

    这道题目使用前序遍历和后序遍历都可以，唯独中序遍历不方便，因为中序遍历会把某些节点的左右孩子翻转了两次！建议拿纸画一画，就理解了

    那么层序遍历可以不可以呢？依然可以的！只要把每一个节点的左右孩子翻转一下的遍历方式都是可以的！*/

    public TreeNode invertTree(TreeNode root) {
        invertByPre(root);
        return root;
    }

    public void invertByPre(TreeNode cur) {
        if (cur == null) {
            return;
        }
        TreeNode tempNode = cur.left;
        cur.left = cur.right;
        cur.right = tempNode;
        invertByPre(cur.left);
        invertByPre(cur.right);
    }
}
