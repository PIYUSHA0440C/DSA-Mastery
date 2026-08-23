# 86. Partition List (Medium)


## 📝 Problem Statement


Given the head of a linked list and a value `x`, partition it such that all nodes with values **less than** `x` come before nodes with values **greater than or equal to** `x`.


The original relative order of the nodes in each partition must be preserved.


## 💡 Intuition & Approach


We divide the linked list into two separate partitions:


- One list contains nodes with values less than `x`.
- The other list contains nodes with values greater than or equal to `x`.


We use two dummy nodes to build these lists. As we traverse the original list, each node is appended to the appropriate partition while preserving its relative order.


Finally, we connect the end of the smaller-values list to the beginning of the greater-or-equal-values list.


### 🛠️ The Strategy:


1. Create two dummy nodes for the two partitions.
2. Use `lessTail` to track the end of the list containing values less than `x`.
3. Use `greaterTail` to track the end of the list containing values greater than or equal to `x`.
4. Traverse the original linked list.
5. Append each node to the appropriate partition based on its value.
6. Set `greaterTail.next` to `null` to terminate the second partition.
7. Connect the less-than partition to the greater-or-equal partition.
8. Return the head of the combined list.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Every node is visited exactly once.


* **Space Complexity:** O(1) - Only a constant number of pointers and dummy nodes are used.


## 💻 Implementation (Java)


```java
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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode lessTail = lessHead;
        ListNode greaterTail = greaterHead;

        ListNode curr = head;

        while(curr != null){
            if (curr.val < x){
                lessTail.next = curr;
                lessTail = curr;
            } else {
                greaterTail.next = curr;
                greaterTail = curr;
            }

            curr = curr.next;
        }

        greaterTail.next = null;

        lessTail.next = greaterHead.next;

        return lessHead.next;
    }
}
