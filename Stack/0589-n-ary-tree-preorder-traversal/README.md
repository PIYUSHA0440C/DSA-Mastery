# 589. N-ary Tree Preorder Traversal (Easy)

## 📝 Problem Statement

Given the root of an **N-ary tree**, return the **preorder traversal** of its nodes' values.

In a preorder traversal, each node is processed **before** recursively visiting all of its children from **left to right**.

The follow-up asks for an **iterative solution** instead of the straightforward recursive approach.

---

## 💡 Intuition & Approach

A recursive preorder traversal naturally visits:

1. Current node
2. Leftmost child to rightmost child

To achieve the same traversal iteratively, we use a **Stack**.

Since a stack follows **Last-In-First-Out (LIFO)** order, we push the children **from right to left**. This ensures that the leftmost child is processed first when popped from the stack.

This approach exactly simulates recursive preorder traversal without relying on the system call stack.

### 🛠️ The Strategy

1. **Handle Empty Tree**
   - If the root is `null`, return an empty list.

2. **Initialize the Stack**
   - Push the root node onto the stack.

3. **Process Nodes**
   - Pop the top node.
   - Add its value to the answer.
   - Push all of its children onto the stack in **reverse order** (right to left).

4. **Repeat**
   - Continue until the stack becomes empty.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every node is visited exactly once.

- **Space Complexity:** **O(n)** - In the worst case, the stack may contain all nodes of a level.

---

## 💻 Implementation (Java)

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> output = new ArrayList<>();

        if(root == null) return output;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            Node node = st.pop();
            output.add(node.val);

            for(int idx = node.children.size() - 1; idx >= 0; idx--) {
                Node child = node.children.get(idx);
                st.push(child);
            }
        }

        return output;
    }
}
```
