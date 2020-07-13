import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author suntao
 * @date 2020/7/13 10:20
 */
public class ReverseNodesInkGroup {

    //25.Reverse Nodes in k-Group

    //Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    //
    //k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    //
    //Example:
    //
    //Given this linked list: 1->2->3->4->5
    //
    //For k = 2, you should return: 2->1->4->3->5
    //
    //For k = 3, you should return: 3->2->1->4->5
    //
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode pre = p;
        ListNode end = p;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;

            pre.next = reverse(start);

            start.next = next;
            pre = start;
            end = pre;

        }
        return p.next;
    }

    private static ListNode reverse(ListNode head) {

        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    public static ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++){
            if (tail == null) {
                return head;
            } else {
                tail = tail.next;
            }
        }
        ListNode res = reverse(head, tail);
        //head是第一轮下来逻辑上的尾节点
        head.next = reverseKGroup1(tail, k);
        return res;
    }
    private static ListNode reverse(ListNode head, ListNode tail){
        ListNode pre = head;
        ListNode cur = head;
        while (cur != tail){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    public ListNode reverseKGroup2(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()){
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode d1 = new ListNode(1);
        ListNode d2 = new ListNode(2);
        ListNode d3 = new ListNode(3);
        ListNode d4 = new ListNode(4);
        ListNode d5 = new ListNode(5);
        d1.next = d2;
        d2.next = d3;
        d3.next = d4;
        d4.next = d5;

        ListNode listNode = reverseKGroup1(d1, 2);
    }
}



