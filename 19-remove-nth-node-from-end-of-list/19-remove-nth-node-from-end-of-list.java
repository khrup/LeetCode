/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

        int nodeLength = 0;
        ListNode tmpNode = head;
        ListNode node = new ListNode(0);
        ListNode node2 = node;
        while (tmpNode != null) {
            nodeLength++;
            tmpNode = tmpNode.next;
        }

        for (int i = 0; i <= nodeLength - n; i++) {
            if (i < nodeLength - n) {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
            } else {
                node2.next = head.next;
                head = head.next;
                node2 = node2.next;
            }
        }
        return node.next;
    }
}