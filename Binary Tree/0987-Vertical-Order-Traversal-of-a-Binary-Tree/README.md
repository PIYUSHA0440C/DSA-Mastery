# 987. Vertical Order Traversal of a Binary Tree (Hard)

## 📝 Problem Statement
Given the `root` of a binary tree, calculate the **vertical order traversal** of the binary tree.

For each node at position `(row, col)`, its left and right children will be at positions `(row + 1, col - 1)` and `(row + 1, col + 1)` respectively. The root of the tree is at `(0, 0)`.

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

## 💡 Intuition & Approach
To solve this problem, we need to map each node to a 2D coordinate system: columns (vertical levels) and rows (depth levels). The output must be sorted strictly from the leftmost column to the rightmost column. Within the same column, nodes must appear from top to bottom (by row index). If multiple nodes share the exact same column and row, they must be sorted in ascending order by their values.

To handle these sorting requirements automatically, we structure our data using a nested **TreeMap** combined with a **PriorityQueue**:
* The outer `TreeMap<Integer, ...>` automatically sorts the columns from left to right.
* The inner `TreeMap<Integer, ...>` automatically sorts the row levels from top to bottom within each column.
* The nested `PriorityQueue<Integer>` handles value ties at identical `(row, col)` positions, maintaining them in ascending order.

We can traverse the tree using a simple recursive helper function (DFS) to populate this nested mapping structure before unpacking it into the final list.

### 🛠️ The Strategy:
1. **Coordinate Mapping:** Traverse the tree recursively. Moving left decrements the column indicator (`verticalLevel - 1`), while moving right increments it (`verticalLevel + 1`). Both directions increment the depth layer (`level + 1`).
2. **Dynamic Collection Insertion:** Check for missing keys at each layer of the nested structure, allocating missing inner maps or priority queues on the fly. Insert the current node's value into the appropriate nested priority queue.
3. **Ordered Unpacking:** Iterate through the outer map keys (columns), then step through each inner map's keys (rows). Empty the min-heap priority queues completely into a temporary column list before appending the sorted data into the final results list.

## 📊 Complexity Analysis
* **Time Complexity:** O(N log N) - Where $N$ is the number of nodes in the binary tree. Each node insertion into the sorted nested TreeMaps and PriorityQueues takes logarithmic time.
* **Space Complexity:** O(N) - Linear space allocation to retain all tree node values inside the nested maps and heap structures.

## 💻 Implementation (Java)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Columns sorted from left-to-right -> Rows sorted from top-to-bottom -> Values sorted min-to-max
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm = new TreeMap<>();
        helper(root, tm, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();

        // Extract values column by column
        for (Integer xasis : tm.keySet()) {
            List<Integer> row = new ArrayList<>();
            TreeMap<Integer, PriorityQueue<Integer>> t = tm.get(xasis);
            
            // Extract values row by row within the current column
            for (Integer level : t.keySet()) {
                PriorityQueue<Integer> pq = t.get(level);
                while (!pq.isEmpty()) {
                    row.add(pq.poll()); // Sorts values at the exact same coordinate automatically
                }
            }
            ans.add(row);
        }

        return ans;
    }

    private void helper(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm, int level, int verticalLevel) {
        if (root == null) return;
        
        // Ensure column map exists
        if (!tm.containsKey(verticalLevel)) {
            tm.put(verticalLevel, new TreeMap<Integer, PriorityQueue<Integer>>());
        }

        // Ensure row priority queue exists
        if (!tm.get(verticalLevel).containsKey(level)) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            tm.get(verticalLevel).put(level, pq);
        }

        // Insert node value into its coordinate bucket
        PriorityQueue<Integer> pq = tm.get(verticalLevel).get(level);
        pq.offer(root.val);

        // Recurse left (col - 1, row + 1) and right (col + 1, row + 1)
        helper(root.left, tm, level + 1, verticalLevel - 1);
        helper(root.right, tm, level + 1, verticalLevel + 1);
    }
}
