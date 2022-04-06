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
    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> ascendingList = new ArrayList<>();

        for (ListNode node : lists) {
            while (node != null) {
                ascendingList.add(node.val);
                node = node.next;
            }
        }

        ascendingList = ascendingList.stream().sorted().collect(Collectors.toList());
        ListNode answer;
        ListNode cloneNode = new ListNode(0);
        answer = cloneNode;

        for (int list : ascendingList) {
            cloneNode.next = new ListNode(list);
            cloneNode = cloneNode.next;
        }


        if(ascendingList.isEmpty()){
            return null;
        }else {
            return answer.next;
        }
    }
}