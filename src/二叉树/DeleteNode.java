package 二叉树;

/**
 * @description：二叉搜索树删除节点 假设root指向 0x001
 * 注意，如果原来有pre.left = root，即pre.left指向0x001
 * root=root.right，只能改变变量root中存放的地址，譬如说root指向了0x005
 * pre.left还是指向0x001
 * @date： 2022/5/10 17:04
 * @author：gqlin
 */
public class DeleteNode {

/*
    450. 删除二叉搜索树中的节点
    给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

    一般来说，删除节点可分为两个步骤：

    首先找到需要删除的节点；
    如果找到了，删除它。


    示例 1:
    输入：root = [5,3,6,2,4,null,7], key = 3
    输出：[5,4,6,2,null,null,7]
    解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
    一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
    另一个正确答案是 [5,2,6,null,4,null,7]。

    示例 2:
    输入: root = [5,3,6,2,4,null,7], key = 0
    输出: [5,3,6,2,4,null,7]
    解释: 二叉树不包含值为 0 的节点

    示例 3:
    输入: root = [], key = 0
    输出: []
    */

    //解题步骤：https://www.programmercarl.com/0450.%E5%88%A0%E9%99%A4%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9.html#java

    public TreeNode deleteNode(TreeNode root, int key) {
        //说明这条路径没有找到key
        if (root == null) return root;
        //如果找到了key
        if (root.val == key) {
            //情况一：仅仅root.left为空（返回right），或者两者都为空（返回null）
            if (root.left == null) {
                return root.right;
            }
            //情况二：root.right为空，left不为空
            else if (root.right == null) {
                return root.left;
            }
            //情况三：left、right都不为空
            else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;//这里仅仅是改变了root的指向，指向原来root地址的那个节点，它的指向还没有改变
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }
}
