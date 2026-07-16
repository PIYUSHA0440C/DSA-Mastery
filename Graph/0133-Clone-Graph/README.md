# 133. Clone Graph (Medium)

## 📝 Problem Statement
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.

Each node in the graph contains a value (`int`) and a list of its neighbors (`List[Node]`).
```java
class Node {
    public int val;
    public List<Node> neighbors;
}
```

## 💡 Intuition & Approach
Cloning a graph requires making a complete duplicate of its structure (nodes and edges) without sharing memory references with the original graph. Because graphs can contain cycles (e.g., Node A points to Node B, and Node B points back to Node A), a naive recursive traversal would end up in an infinite loop.

To prevent infinite recursion and correctly map relationships, we use a **HashMap** to act as a registry of cloned nodes. The map associates each original node with its corresponding cloned counterpart (`HashMap<Node, Node>`).

We use a **Depth-First Search (DFS)** traversal strategy:
1. **Lookup Register:** Before cloning a node, check if it already exists in our map. If it does, we simply return the already cloned reference.
2. **Instantiate Copy:** If it is a new node, instantiate its clone using its value, and immediately register the pair in the map.
3. **Recursive Edge Binding:** Iterate through the neighbors of the original node. For each neighbor, recursively call the cloning routine and add the resulting cloned node to our current cloned node's neighbor list.

### 🛠️ The Strategy:
1. **Base Case Validation:** If the input node is null, return `null`.
2. **Cycle Resolution:** If `map.containsKey(node)` is true, return `map.get(node)` to break traversal loops.
3. **Deep Copy Creation:** Instantiate `Node clone = new Node(node.val)` and map the original node to this copy.
4. **Neighbor Replication:** For every neighbor in `node.neighbors`, append `cloneGraph(neighbor)` to the clone's neighbor list.

## 📊 Complexity Analysis
* **Time Complexity:** O(V + E) - Where $V$ is the number of vertices (nodes) and $E$ is the number of edges. We visit every node and traverse every edge exactly once.
* **Space Complexity:** O(V) - The lookup table stores mapping configurations for up to $V$ nodes. Additionally, the recursion stack takes up to $O(H)$ space, where $H$ is the maximum depth of the graph.

## 💻 Implementation (Java)
```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node nei : node.neighbors) {
            clone.neighbors.add(cloneGraph(nei));
        }

        return clone;
    }
}
```
