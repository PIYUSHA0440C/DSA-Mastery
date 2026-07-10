# 116. Populating Next Right Pointers in Each Node (Medium)

## 📝 Problem Statement
You are given a **perfect binary tree** where all leaves are on the same level, and every parent has two children. 

Populate each `next` pointer to point to its next right node. If there is no next right node, the `next` pointer should be set to `NULL`. Initially, all `next` pointers are set to `NULL`.

## 💡 Intuition & Approach
The problem requires us to connect sibling nodes horizontally across the tree. Because the input is a **perfect binary tree**, every internal node has exactly two children, which simplifies the structural links we need to form.

When standing at a parent node, there are two distinct types of horizontal connections to establish for the level below:
1. **Intra-parent connection (Same Parent):** Connecting the left child directly to the right child of the current node (`root.left.next = root.right`).
2. **Inter-parent connection (Cross-Parent):** Connecting the right child of the current node to the left child of the next node on the same level. Since the parent's `next` pointer is already established from the previous level's processing, we can simply trace across via `root.next` to bridge the gap (`root.right.next = root.next.left`).

By utilizing a Pre-Order Traversal (Root $\rightarrow$ Left $\rightarrow$ Right), we ensure that the `next` pointers at the parent level are fully configured before the recursion descends to process the children.

### 🛠️ The Strategy:
1. **Base Case:** If `root` is null, return `null`.
2. **Establish Sibling Link:** If `root.left` exists, link it directly to `root.right`.
3. **Establish Cousin Link:** If `root.right` exists and `root.next` is not null, bridge the cross-parent gap by setting `root.right.next = root.next.left`.
4. **Recursive Descent:** Deeply recurse down `root.left` followed by `root.right`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - Every node in the perfect binary tree is visited exactly once to adjust its children's horizontal pointers.
* **Space Complexity:** O(H) - The maximum space allocated on the implicit call stack corresponds directly to the tree height $H$. For a perfect binary tree, $H = \log N$. No extra auxiliary data structures are used, satisfying the space constraints.

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
        if (root == null) return null;
        
        // Connection Type 1: Sibling connection under the same parent
        if (root.left != null) {
            root.left.next = root.right;
        }
        
        // Connection Type 2: Cousin connection across adjacent parent nodes
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        
        // Recurse left and right subtrees
        connect(root.left);
        connect(root.right);

        return root;
    }
}
