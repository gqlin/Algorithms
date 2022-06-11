package 双指针;

/**
 * @description：
 * @date： 2022/4/17 22:37
 * @author：gqlin
 */
public class SwapPaird {
    /*    24. 两两交换链表中的节点
        给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



        示例 1：


        输入：head = [1,2,3,4]
        输出：[2,1,4,3]
        示例 2：

        输入：head = []
        输出：[]
        示例 3：

        输入：head = [1]
        输出：[1]*/
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode simHead = new ListNode();
        simHead.next = head;

        ListNode cur = simHead;
        ListNode nextNode = simHead.next;


        //原链表不少于两个节点
        while (nextNode.next != null && nextNode != null) {
            ListNode nextNextNode = cur.next.next;
            ListNode nextNextNestNode = cur.next.next.next;

            cur.next = nextNextNode;
            nextNextNode.next = nextNode;
            nextNode.next = nextNextNestNode;

            cur = nextNode;
            nextNode = cur.next;
            if (nextNode == null) {
                break;
            }
        }

        simHead = simHead.next;
        return simHead;
    }
}
