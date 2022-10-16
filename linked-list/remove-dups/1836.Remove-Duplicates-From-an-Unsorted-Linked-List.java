// Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.
// Return the linked list after the deletions.
// Exmple:
// Input: head = [1,2,3,2]
// Output: [1,3]
// Explanation: 2 appears twice in the linked list, so all 2's should be deleted. After deleting all 2's, we are left with [1,3].
//https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/discuss/1173589/Simple-Java-Two-Pass-90-With-Explanation-and-Picture-Time-Complexity-O(N)-Space-Complexity-O(N)
// Time Complexity is O(2N) as we pass through the list two times where N is the length of the list.
// Space Complexity is O(N) in worst scenario where each Node in the list has unique (not repeated) values.

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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> repeatedNodes = new HashMap<>();
        ListNode tempNode = new ListNode();
        tempNode.next = head;
        ListNode cur = head;
        while(cur != null) {
            repeatedNodes.put(cur.val, repeatedNodes.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }
        
        ListNode prev = tempNode;
        cur = head;
        while(cur != null) {
            if(repeatedNodes.get(cur.val) > 1) {
                prev.next = cur.next;
                cur.next = null;
                cur = prev;
            }
            prev = cur;
            cur = cur.next;
        }
        return tempNode.next;
    }
}