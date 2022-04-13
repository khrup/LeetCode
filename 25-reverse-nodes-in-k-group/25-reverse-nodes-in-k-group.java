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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(k == 1) return head;
        
        List<Integer> list = new ArrayList<>();
        ListNode kHead = new ListNode();

        int totalCnt = 0;
        ListNode tmp = head;
        while (!Objects.isNull(tmp)) {
            totalCnt++;
            tmp = tmp.next;
        }

        for (int i = 0; i < totalCnt / k; i++) {
            for (int j = 1; j <= k; j++) {
                list.add(head.val);
                head = head.next;
                kHead = head;
            }
        }

        List<Integer> headList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if(k * i + k <= list.size()) {
                List<Integer> t = list.subList(k * i, k * i + k);
                Collections.reverse(t);
                headList.addAll(t);
            }
        }

        ListNode newHead;
        ListNode tmpHead = new ListNode();
        newHead = tmpHead;

        for (int i = 0; i < headList.size(); i++) {

            int value = headList.get(i);

            tmpHead.next = new ListNode(value);
            tmpHead = tmpHead.next;

            if (i + 1 == headList.size()) {
                tmpHead.next = kHead;
            }
        }

        return newHead.next;

    }
}