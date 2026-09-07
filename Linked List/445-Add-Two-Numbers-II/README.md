# 445. Add Two Numbers II (Medium)

## 📝 Problem Statement

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first. Add the two numbers and return the sum as a linked list.

The input lists cannot be reversed, so the digits are processed from least significant to most significant using stacks.

## 💡 Intuition & Approach

Since the digits are stored in forward order, directly adding corresponding nodes would process the numbers from the most significant digit, which is not suitable for addition. Stacks allow us to access the digits from right to left without modifying the input lists.

### 🛠️ The Strategy:

1. Traverse `l1` and push each digit onto `stack1`.
2. Traverse `l2` and push each digit onto `stack2`.
3. Pop digits from both stacks to process the numbers from least significant to most significant.
4. Add the two digits along with the current `carry`.
5. Create a new node for the resulting digit.
6. Insert each newly created node at the front of the result list.
7. Continue while either stack has digits remaining or a carry exists.
8. Return the constructed result list.

## 📊 Complexity Analysis

* **Time Complexity:** O(n + m)
* **Space Complexity:** O(n + m)

## 💻 Implementation (Java)

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        ListNode node1 = l1;
        ListNode node2 = l2;

        while(node1 != null){ 
            stack1.push(node1.val);
            node1 = node1.next;
        }
        while(node2 != null){
            stack2.push(node2.val);
            node2 = node2.next;
        }

        ListNode head = null;
        int carry = 0;

        while(!stack1.isEmpty() || !stack2.isEmpty() ||carry != 0){
            int sum = 0;

            if(!stack1.isEmpty()) sum += stack1.pop();
            if(!stack2.isEmpty()) sum += stack2.pop();

            sum += carry;

            int value = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(value);
            node.next = head;

            head = node;
        }
        return head;
    }
}
```
