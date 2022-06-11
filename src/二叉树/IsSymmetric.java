package 二叉树;

/**
 * @description：
 * @date： 2022/5/1 18:31
 * @author：gqlin
 */
public class IsSymmetric {
/*    101. 对称二叉树
    给你一个二叉树的根节点 root ， 检查它是否轴对称。



    示例 1：


    输入：root = [1,2,2,3,4,4,3]
    输出：true
    示例 2：


    输入：root = [1,2,2,null,3,null,3]
    输出：false


    提示：

    树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100*/


/*    解题步骤：
    递归三部曲

    1.确定递归函数的参数和返回值
    因为我们要比较的是根节点的两个子树是否是相互翻转的，进而判断这个树是不是对称树，所以要比较的是两个树，
    参数自然也是左子树节点和右子树节点。返回值自然是bool类型。
    代码如下：
    bool compare(TreeNode* left, TreeNode* right)

    2.确定终止条件
    要比较两个节点数值相不相同，首先要把两个节点为空的情况弄清楚！否则后面比较数值的时候就会操作空指针了。

    节点为空的情况有：（注意我们比较的其实不是左孩子和右孩子，所以如下我称之为左节点右节点）

    左节点为空，右节点不为空，不对称，return false
    左不为空，右为空，不对称 return false
    左右都为空，对称，返回true
    此时已经排除掉了节点为空的情况，那么剩下的就是左右节点不为空：

    左右都不为空，比较节点数值，不相同就return false
    此时左右节点不为空，且数值也不相同的情况我们也处理了。

    代码如下：

            if (left == NULL && right != NULL) return false;
            else if (left != NULL && right == NULL) return false;
            else if (left == NULL && right == NULL) return true;
            else if (left->val != right->val) return false; // 注意这里我没有使用else
    注意上面最后一种情况，我没有使用else，而是elseif， 因为我们把以上情况都排除之后，剩下的就是 左右节点都不为空，且数值相同的情况。

    3.确定单层递归的逻辑
    此时才进入单层递归的逻辑，单层递归的逻辑就是处理 左右节点都不为空，且数值相同的情况。

    比较二叉树外侧是否对称：传入的是左节点的左孩子，右节点的右孩子。
    比较内测是否对称，传入左节点的右孩子，右节点的左孩子。
    如果左右都对称就返回true ，有一侧不对称就返回false 。*/

    public boolean isSymmetric(TreeNode root) {
        return ifSame(root.left, root.right);
    }

    public boolean ifSame(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        boolean res1 = ifSame(left.left, right.right);
        boolean res2 = ifSame(left.right, right.left);
        return res1 && res2;
    }
}
