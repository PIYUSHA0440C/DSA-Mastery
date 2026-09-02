# 1019. Next Greater Node In Linked List (Medium)


## 📝 Problem Statement


Given the head of a linked list, find the value of the first node after each node that has a strictly greater value.


If no greater node exists, the answer for that node is `0`.


## 💡 Intuition & Approach


The key challenge is finding the next greater value efficiently without repeatedly scanning the remaining nodes.


We first convert the linked list into an `ArrayList` so that each node can be accessed by its index. Then, we use a **Monotonic Stack** to keep track of indices whose next greater value has not been found yet.


When the current value is greater than the value at the index on top of the stack, the current value becomes the next greater node for that index. We continue removing such indices until the stack is empty or its top value is greater than or equal to the current value.


### 🛠️ The Strategy:


1. Store all linked list values in an `ArrayList`.
2. Create a result array initialized with `0`.
3. Traverse the values from left to right.
4. Store unresolved indices in a monotonic decreasing stack.
5. When the current value is greater, resolve the corresponding indices.
6. Push the current index onto the stack.
7. Unresolved indices remain `0` in the result.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Each index is pushed onto and popped from the stack at most once.


* **Space Complexity:** O(n) - The list and stack both require space proportional to the number of nodes.


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
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        ListNode tail = head;

        while(tail != null) {
            list.add(tail.val);
            tail = tail.next;
        }

        int size = list.size();
        int result[] = new int[size];

        for(int i = 0; i < size; i++){
            while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }

            stack.push(i);
        }

        return result;
    }
}
