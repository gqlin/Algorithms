package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description：层序遍历
 * @date： 2022/4/29 19:21
 * @author：gqlin
 */
public class LevelOrder {
/*
    102. 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。



    示例 1：


    输入：root = [3,9,20,null,null,15,7]
    输出：[[3],[9,20],[15,7]]
    示例 2：

    输入：root = [1]
    输出：[[1]]
    示例 3：

    输入：root = []
    输出：[]*/

    //解题思路：https://www.programmercarl.com/0102.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86.html

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelTraversal(root, result);
        return result;
    }

    //BFS--迭代方式--借助队列
    public void levelTraversal(TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();//辅助遍历树的队列
        queue.offer(node);//根节点入列（可以理解为第一层节点入队）

        //外层循环遍历一层
        while (!queue.isEmpty()) {
            int length = queue.size();//length就是一层的节点数
            ArrayList<Integer> tempList = new ArrayList<>();
            //内层循环遍历一层每个节点
            while (length > 0) {
                TreeNode tempNode = queue.remove();//队列头节点出队，也就是该层的其中一个元素出队

                //此元素出队时要检查，如果元素 左/右 节点不为空，也就是有下一层，将下一层节点入队
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                tempList.add(tempNode.val);
                length--;
            }
            result.add(tempList);
        }
        return;
    }
}
