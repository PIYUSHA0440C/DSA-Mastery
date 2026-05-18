# 876. Middle of the Linked List (Easy)

## 📝 Problem Statement
Given the `head` of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.

## 💡 Intuition & Approach
The most efficient way to find the middle of a linked list in a single pass is by using the **Fast and Slow Pointer** approach (also known as Floyd's Tortoise and Hare algorithm).

### 🛠️ The Strategy:
1. **Initialize Pointers:** Place both `slow` and `fast` pointers at the `head` of the linked list.
2. **Traversal:** Move the `slow` pointer forward by **one node** (`slow = slow.next`) and the `fast` pointer forward by **two nodes** (`fast = fast.next.next`) at each step.
3. **Termination Condition:** 
   - For an **odd-length** list, the loop terminates when `fast.next == null`.
   - For an **even-length** list, the loop terminates when `fast == null`.
4. **Result:** Because `fast` travels at twice the speed of `slow`, when `fast` reaches the end of the list, `slow` will be standing exactly at the middle node.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the linked list exactly once.
* **Space Complexity:** 𝙊(𝟭) - Only two reference pointers are used, requiring constant auxiliary memory.

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
    public ListNode middleNode(ListNode head) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with two different speeds
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
