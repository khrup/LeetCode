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
public ListNode swapPairs(ListNode head) {

        List<ListNode> swapNodes = new ArrayList<>();
        int pairCheck = 0;
        ListNode prevNode = null;
        ListNode tmpNode = head;

        if (head != null && head.next != null) {
            while (tmpNode != null) {

                if (++pairCheck % 2 == 1) {
                    prevNode = tmpNode;
                } else {
                    ListNode newNode = new ListNode(tmpNode.val);
                    newNode.next = prevNode;
                    newNode.next.next = null;
                    swapNodes.add(newNode);
                }
                tmpNode = tmpNode.next;
                if(tmpNode==null && pairCheck % 2 == 1){

                    swapNodes.add(prevNode);
                }
            }

            ListNode answer = new ListNode(0);
            ListNode tmp = answer;

            for (int i = 0; i < swapNodes.size(); i++) {
                tmp.next = swapNodes.get(i);
                if(tmp.next != null) {
                    tmp = tmp.next.next;
                }
            }

            return answer.next;
        } else {
            return head;
        }
    }
}