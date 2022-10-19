//Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
// Output: Intersected at '8'
// 4 -> 1 ->    
//                 8 -> 4 -> 5
// 5 -> 6 -> 1 ->

//Approach 1: Hash Table
// Time complexity : O(N + M)
// Space complexity : O(M)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodesInB = new HashSet<ListNode>();

        while (headB != null) {
            nodesInB.add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            // if we find the node pointed to by headA,
            // in our set containing nodes of B, then return the node
            if (nodesInB.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }

        return null;
    }
}

//Approach 2: Two Pointers
//Algorithm:
// Set pointer pA to point at headA.
// Set pointer pB to point at headB.
// While pA and pB are not pointing at the same node:
// If pA is pointing to a null, set pA to point to headB.
// Else, set pA to point at pA.next.
// If pB is pointing to a null, set pB to point to headA.
// Else, set pB to point at pB.next.
// return the value pointed to by pA (or by pB; they're the same now).
//Time complexity : O(N + M)
//Space complexity : O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
        // Note: In the case lists do not intersect, the pointers for A and B
        // will still line up in the 2nd iteration, just that here won't be
        // a common node down the list and both will reach their respective ends
        // at the same time. So pA will be NULL in that case.
    }
}