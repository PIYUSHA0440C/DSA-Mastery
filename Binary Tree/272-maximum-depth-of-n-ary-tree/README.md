# 559. Maximum Depth of N-ary Tree (Easy)

## 📝 Problem Statement

Given the root of an N-ary tree, return its maximum depth. The maximum depth is the number of nodes along the longest path from the root to the farthest leaf node.

## 💡 Intuition & Approach

The depth of a node is one greater than the maximum depth among its children. Use recursion to calculate the depth of each child and keep track of the maximum.

If the root is `null`, the tree is empty, so its depth is `0`. Otherwise, start the maximum depth at `1` for the root and check every child.

### 🛠️ The Strategy:

1. If `root` is `null`, return `0`.
2. Initialize `max` to `1` to count the root node.
3. Traverse all children of the current node.
4. Recursively calculate each child's depth and update `max` with the largest depth.
5. Return `max`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where `n` is the number of nodes, because each node is visited once.
- **Space Complexity:** O(h), where `h` is the maximum tree depth, due to the recursive call stack. In the worst case, this is O(n).

## 💻 Implementation (Java)

```java
/*
Definition for a Node.
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
    public int maxDepth(Node root) {
        if (root == null) return 0;

        int max = 1;

        for (Node child : root.children) {
            max = Math.max(max, 1 + maxDepth(child));
        }

        return max;
    }
}
```
