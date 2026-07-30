# 23. Merge k Sorted Lists (Hard)

## 📝 Problem Statement

You are given an array of `k` sorted linked lists. Merge all the linked lists into a single sorted linked list and return its head.

The total number of nodes across all linked lists does not exceed `10⁴`.

---

## 💡 Intuition & Approach

Each linked list is already sorted, so instead of merging all lists repeatedly, we only need to know the **smallest current node** among the heads of all lists.

A **Min Heap (Priority Queue)** efficiently provides the smallest available node at every step.

The algorithm works as follows:

- Insert the head of every non-empty linked list into the priority queue.
- Extract the smallest node and append it to the merged list.
- If the extracted node has a next node, insert that next node into the priority queue.
- Continue until the priority queue becomes empty.

Since the heap never contains more than one node from each list, its maximum size is `k`.

### 🛠️ The Strategy

1. **Initialize a Min Heap**
   - Store the head node of every non-empty linked list.

2. **Create the Result List**
   - Use a dummy node to simplify list construction.

3. **Process the Heap**
   - Remove the smallest node from the heap.
   - Append it to the merged list.
   - If that node has a next node, push it into the heap.

4. **Return the Merged List**
   - The merged list starts from `dummy.next`.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(N log k)**, where `N` is the total number of nodes and `k` is the number of linked lists. Each node is inserted into and removed from the priority queue exactly once.

- **Space Complexity:** **O(k)**, as the priority queue stores at most one node from each linked list at any time.

---

## 💻 Implementation (Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();

            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}
```
