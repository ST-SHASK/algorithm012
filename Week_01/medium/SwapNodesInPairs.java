/**
 * @author suntao
 * @date 2020/7/13 9:03
 */
public class SwapNodesInPairs {

    //24.Swap Nodes in Pairs

    //Given a linked list, swap every two adjacent nodes and return its head.
    //
    //You may not modify the values in the list's nodes, only nodes itself may be changed.
    //
    // 
    //
    //Example:
    //
    //Given 1->2->3->4, you should return the list as 2->1->4->3.
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head, right = head.next;

        left.next = swapPairs(right.next);

        right.next = left;

        return right;

    }

    public ListNode swapPairs2(ListNode head) {
        // 滑动  head 节点的位置。 迭代 两两交换 next 指向
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode prev = p;

        while (head != null && head.next != null) {

            ListNode left = head;
            ListNode right = head.next;

            // swap
            prev.next = right;
            left.next = right.next;
            right.next = left;

            // re init
            head = left.next;
            prev = left;
        }

        return p.next;
    }

}
