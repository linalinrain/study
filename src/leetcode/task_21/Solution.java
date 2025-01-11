package leetcode.task_21;

public class Solution {
    // https://leetcode.com/problems/valid-parentheses/description/
    // You are given the heads of two sorted linked lists list1 and list2.
    // Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    // Return the head of the merged linked list.

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headOfTheMergedList = new ListNode(-1);
        ListNode currentListNode = headOfTheMergedList;

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                currentListNode.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                currentListNode.next = ptr2;
                ptr2 = ptr2.next;
            }
            currentListNode = currentListNode.next;
        }

        if (ptr1 != null) {
            currentListNode.next = ptr1;
        } else {
            currentListNode.next = ptr2;
        }

        return headOfTheMergedList.next;
    }
}