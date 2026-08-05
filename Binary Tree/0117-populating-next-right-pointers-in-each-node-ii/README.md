# 117. Populating Next Right Pointers in Each Node II (Medium)

## 📝 Problem Statement

Given the root of a binary tree where each node contains a `next` pointer, populate every `next` pointer so that it points to its immediate right node on the same level. If there is no such node, the `next` pointer should be set to `null`.

The solution should work for any binary tree, not necessarily a perfect binary tree.

---

## 💡 Intuition & Approach

Instead of using a queue for level-order traversal, we can leverage the already established `next` pointers to traverse each level while constructing the `next` pointers for the following level.

A **dummy node** acts as the starting point of the next level, while another pointer (`curr`) is used to connect all children encountered during the traversal of the current level.

For every level:

- Traverse nodes using their existing `next` pointers.
- Connect each non-null left and right child to the next level.
- After finishing the current level, move to the first node of the next level using `dummy.next`.

This approach processes the tree level by level while using only **constant extra space**.

### 🛠️ The Strategy

1. **Start from the Root**
   - Let `head` point to the first node of the current level.

2. **Build the Next Level**
   - Create a dummy node.
   - Use `curr` to connect every child encountered.

3. **Traverse the Current Level**
   - Move across the current level using the existing `next` pointers.
   - Link the left child, then the right child, if they exist.

4. **Move to the Next Level**
   - Set `head = dummy.next`.
   - Repeat until no more levels remain.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every node is visited exactly once.

- **Space Complexity:** **O(1)** - Only a few pointers are used, excluding the implicit recursion stack (this solution is iterative).

---

## 💻 Implementation (Java)

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node head = root;

        while (head != null) {
            Node dummy = new Node(0);
            Node curr = dummy;

            while (head != null) {
                if (head.left != null) {
                    curr.next = head.left;
                    curr = curr.next;
                }

                if (head.right != null) {
                    curr.next = head.right;
                    curr = curr.next;
                }

                head = head.next;
            }

            head = dummy.next;
        }

        return root;
    }
}
```
