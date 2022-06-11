package 二叉树;

import java.util.*;

/**
 * @description：
 * @date： 2022/5/3 9:33
 * @author：gqlin
 */
public class FindBottomLeftValue {
/*    513. 找树左下角的值
    给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。

    假设二叉树中至少有一个节点。

    示例 1:
    输入: root = [2,1,3]
    输出: 1

    示例 2:
    输入: [1,2,3,4,null,5,6,null,null,7]
    输出: 7*/

    /*解题步骤：
    本题使用层序遍历再合适不过了，比递归要好理解的多！

    只需要记录最后一行第一个节点的数值就可以了。*/

    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int result = 0;

        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            int index = 0;
            while (index < size) {
                TreeNode temp = treeNodes.remove();
                if (index == 0) {
                    result = temp.val;
                }

                if (temp.left != null) {
                    treeNodes.offer(temp.left);
                }
                if (temp.right != null) {
                    treeNodes.offer(temp.right);
                }
                index++;
            }
        }
        return result;
    }

}
