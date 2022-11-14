// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.
// Exmp:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

// Input: lists = []
// Output: []

// Input: lists = [[]]
// Output: []

//The interviewer asked me the totally same question.
// However, he said brute force was not allowed.
// Additionally, he asked me to use heap, and the max size of heap should be the length of lists (not the # of all nodes).
// Most importantly, I had to implement ListNode class and initialize the test cases by myself.
//Java heap ---> PriorityQueue
//Max heap:  PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
//https://leetcode.com/problems/merge-k-sorted-lists/discuss/2802497/Java-or-2023-NG-Tiktok-VO-(Restrictions-Attached)-or-TCO(nlogk)-or-SCO(n)

// Time complexity : O(Nlogk) where k is the number of linked lists.
// The comparison cost will be reduced to O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1) time.
// There are N nodes in the final linked list.

// Space complexity :
// O(n) Creating a new linked list costs O(n) space.
// O(k) The code above present applies in-place method which cost O(1) space. And the priority queue (often implemented with heaps) costs O(k) space (it's far less than N in most situations).
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val); //min heap
        ListNode ans = new ListNode(-10001); // sentry
        ListNode ptr = ans;
        for (ListNode tmp : lists) {
            if (tmp != null) pq.add(tmp);
        }
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            ListNode newNode = new ListNode(cur.val);
            ptr.next = newNode;
            ptr = ptr.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return ans.next;
    }
}