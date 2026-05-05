# 61. Rotate List (Medium)

## 📝 Problem Statement
Given the `head` of a linked list, rotate the list to the right by `k` places.

## 💡 Intuition & Approach
Rotating a linked list to the right is essentially shifting the "cutoff point." Instead of moving elements one by one, we can connect the end of the list to the beginning to form a circle, and then break the circle at the appropriate new tail.

### 🛠️ The Strategy:
1. **Handle Edge Cases:** If the list is empty, has one node, or $k=0$, return `head`.
2. **Calculate Length:** Traverse the list to find its length `L` and the last node.
3. **Normalize k:** The effective rotation is `k % L`. If `k % L == 0`, no rotation is needed.
4. **Make it Circular:** Connect the last node's `next` pointer to the `head`.
5. **Find the New Breakpoint:** - The new tail will be at position `L - (k % L) - 1` from the start.
   - The new head will be `newTail.next`.
6. **Break the Circle:** Set `newTail.next = null` and return the `newHead`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the list once to find the length and once more (at most) to find the new tail.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures are used; we only manipulate pointers.

## 💻 Implementation (Java)
```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Compute the length
        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        // 2. Normalize k and check if rotation is needed
        k = k % length;
        if (k == 0) return head;

        // 3. Make the list circular
        oldTail.next = head;

        // 4. Find the new tail: (length - k - 1) steps from head
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;

        // 5. Break the circle
        newTail.next = null;

        return newHead;
    }
}
